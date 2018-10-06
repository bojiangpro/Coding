import unittest
import numpy as np
import random
from RegularExpressionMatching.Solution import Solution

class Test(unittest.TestCase):
    
    def __test(self, s, p, target):
        solution = Solution()
        isMatch = solution.isMatch(s, p)
        self.assertEqual(isMatch, target, s+'\n'+p)

    def test(self):
        self.__test('a', '', False)
        self.__test('aa', 'a', False)
        self.__test("a", "ab*", True)
        self.__test('aa', 'a*', True)
        self.__test('aaa', 'a*a', True)
        self.__test('ab', '.*', True)
        self.__test('aab', 'c*a*b', True)
        self.__test('mississippi', 'mis*is*p*.', False)
        self.__test("aaaaaaaaaaaaab", "a*c*c*f*g*h*k*a*k*l*o*p*y*b", True)
        self.__test("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b", True)
        self.__test("aaaccbccbcbaabcaa", "c*a*.*a*.*c*.c*.a*c", False)
        self.__test("mississippi", "mis*is*ip*.", True)
        self.__test("cbabcbbaabbcaca", ".a*b*.*.*b*c*.*b*a*", True)

    def testRandom(self):
        pass


if __name__ == '__main__':
    unittest.main()