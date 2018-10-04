import unittest
import numpy as np
from MedianOf2SortedNumbers.Solution import Solution

class Test(unittest.TestCase):
    def setUp(self):
        self._s = Solution()
    
    def __test(self, nums1, nums2, expected):
        v = self._s.findMedianSortedArrays(nums1, nums2)
        self.assertEqual(v, expected, 
            ' '.join(str(e) for e in nums1)+'\n'+
            ' '.join(str(e) for e in nums2))

    def test_sanity(self):
        self.__test([], [1, 2, 3], 2)
        self.__test([1, 2, 3], [], 2)
        self.__test([1, 3], [2], 2)
        self.__test([1, 2], [3], 2)
        self.__test([1, 3], [2, 4], 2.5)
        self.__test([0, 1 ,1, 3, 3, 4], [0 ,0, 3, 4, 4 ,4 ,5 ,6], 3)
        self.__test([0, 0, 2, 3, 4, 4, 4, 4, 4, 5, 5], [6, 6, 6], 4)
    
    def test_random(self):
        for i in range(0, 10000):
            np.random.seed(i)
            N = np.random.randint(10, 500)
            ori = np.sort(np.random.randint(0, int(0.8*N), N))
            data = list(zip(ori, np.random.rand(N)))
            data.sort(key=lambda t:t[1])
            p = np.random.randint(1, N-1)
            a = np.sort([data[i][0] for i in range(0, p)])
            b = np.sort([data[i][0] for i in range(p, N)])
            self.__test(a, b, np.mean(ori[Solution.medianIndices(a, b)]))

if __name__ == '__main__':
    unittest.main()