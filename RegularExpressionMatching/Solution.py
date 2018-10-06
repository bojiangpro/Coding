
class Solution:

    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if not p:
            return not s
        patterns = self.splitPatterns(p)
        s_len = len(s) 
        p_len = len(patterns)
        dp = [[False] * (s_len + 1) for _ in range(p_len + 1)]

        dp[-1][-1] = True
        for i in range(p_len-1, -1, -1):
            if len(patterns[i])>1:
                for j in range(s_len, -1, -1):
                    dp[i][j] = dp[i+1][j] or (j < s_len and Solution.isEqaul(s[j], patterns[i][0]) and dp[i][j+1])
            else:
                for j in range(s_len, -1, -1):
                    dp[i][j] = j < s_len and Solution.isEqaul(s[j], patterns[i]) and dp[i+1][j+1]
        
        return dp[0][0]

        
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
