class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = 0
        start = 0
        charSet = set()
        for i in range(len(s)):
            c = s[i]
            if c in charSet:
                l = len(charSet)
                if l > count:
                    count = l
                while s[start] != c:
                    charSet.remove(s[start])
                    start += 1
                start += 1
            else:
                charSet.add(c)
        return max(count, len(charSet))