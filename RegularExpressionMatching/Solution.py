from queue import Queue
class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if len(p) == 0:
            return len(s) == 0
        patterns = self.splitPatterns(p)
        match_queue = Queue()
        match_queue.put_nowait((0, 0))
        s_len = len(s) 
        p_len = len(patterns)
        while not match_queue.empty():
            i, j = match_queue.get_nowait()
            if s_len <= i:
                if p_len <= j or all([len(patterns[k])==2 for k in range(j, p_len)]):
                    return True
                else:
                    continue
            if p_len <= j:
                continue
            pattern = patterns[j]
            if len(pattern) == 2:
                # pattern is char*
                # 1. match zero time
                match_queue.put_nowait((i, j+1))
                if Solution.isEqaul(s[i], pattern[0]):
                # 2. match one time
                    match_queue.put_nowait((i+1, j+1))
                # 3. match n times
                    match_queue.put_nowait((i+1, j))
            else:
                if Solution.isEqaul(s[i], pattern[0]):
                    match_queue.put_nowait((i+1, j+1))
        return False

        
    @staticmethod
    def isEqaul(c, p):
        return p == c or p == '.'
    
    @staticmethod
    def splitPatterns(pattern):
        patterns = []
        i = 1
        while i < len(pattern):
            if pattern[i] == '*':
                p = pattern[i-1:i+1]
                if len(patterns) == 0 or patterns[-1] != p:
                    patterns.append(p)
                i += 2
            else:
                patterns.append(pattern[i-1])
                i += 1
        if pattern[-1] != '*':
            patterns.append(pattern[-1])
        
        return patterns
