import unittest
import numpy as np
from LongestSubString.Solution import Solution

class Test(unittest.TestCase):
    def setUp(self):
        self._s = Solution()
    
    def __test(self, s, expected):
        v = self._s.lengthOfLongestSubstring(s)
        self.assertEqual(v, expected, s)

    def test_sanity(self):
        self.__test("abcabcbb", 3)
        self.__test("bbbbb", 1)
        self.__test("pwwkew", 3)
        self.__test(" ", 1)
        self.__test("dvdf", 3)
    
    def test_random(self):
        pass

if __name__ == '__main__':
    unittest.main()