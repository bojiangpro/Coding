import unittest
import numpy as np
import random
from TwoSum.Solution import Solution

class Test(unittest.TestCase):
    
    def __test(self, nums, target):
        s = Solution()
        indices = s.twoSum(nums, target)
        sum_number = sum(nums[i] for i in indices)
        self.assertEqual(sum_number, target, ",".join(str(n) for n in nums))

    def test(self):
        self.__test([2, 7, 11, 15], 9)
        self.__test([124,70,42,9,135,51,101,47,30,38,146,151,119,70,88,39,49,39,85,108,38,84,144,134,46,82,154,121,94,26,74,121,51,25,10,7,15,131,52,125,75,142,74,23,132,47,51,125,109,98,53,42,59,66,61,149,29,140,76,127,23,129,8,38,79,58,110,29,70,156,85,14,38,88,87,76,76,41,144,3,16,3,4,30,128,75,58,29,10,53,36,93,129,142,105,147,21,51,73,1,77,66,75,118,25,43,31,102,148,112,14,30,2,18,118,17,74,39,116,62,98,81,60,125,123,61,14,118,97,157,123,121,48,35,75,75,83,115,46,119,117,58,14,43,96,126,129,12,117,84,40,0,136,93,134,96,69,36],
                    157)

    def testRandom(self):
        for i in range(1000):
            random.seed(i)
            N = random.randint(10, 1000)
            nums = np.random.randint(0, N, N).tolist()
            f = random.randint(0, N-2)
            s = random.randint(f+1, N-1)
            target = nums[f]+nums[s]
            self.__test(nums, target)


if __name__ == '__main__':
    unittest.main()