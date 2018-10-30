import unittest
import numpy as np
from MergeKSortedLists.Solution import Solution, ListNode

class Test(unittest.TestCase):
    def setUp(self):
        self._s = Solution()
    
    @staticmethod
    def __createList(nums):
        h = ListNode(0)
        node = h
        for n in nums:
            node.next = ListNode(n)
            node = node.next
        return h.next
    
    @staticmethod
    def __createArray(head):
        node = head
        a = []
        while node:
            a.append(node.val)
            node = node.next
        return a

    def __test(self, num_arr, expected):
        lists = [self.__createList(nums) for nums in num_arr]
        v = self._s.mergeKLists(lists)
        self.assertEqual(self.__createArray(v), expected, v)

    def test_sanity(self):
        self.__test([[1,4,5],
                    [1,3,4],
                    [2,6]], [1,1,2,3,4,4,5,6])
        self.__test([[]], [])
    
    def test_random(self):
        pass

if __name__ == '__main__':
    unittest.main()