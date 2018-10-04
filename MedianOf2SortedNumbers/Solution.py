from bisect import bisect_left
import math

class Solution():

    @staticmethod
    def medianIndices(nums1, nums2):
        index = Solution.medianIndex(nums1, nums2)
        if Solution.isTie(nums1, nums2):
            return [index, index+1]
        return [index]
    
    @staticmethod
    def medianIndex(nums1, nums2):
        return int(math.ceil(len(nums1)+len(nums2)-1)/2)

    @staticmethod
    def isTie(nums1, nums2):
        return (len(nums1)+len(nums2))%2 == 0

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        index = self.medianIndex(nums1, nums2)
        l1, l2 = len(nums1), len(nums2)
        
        r = self.__findItem(nums1, nums2, (0, min(index+1, l1)), (0, min(index+1,l2)), index)
        while not r[0]:
            r = self.__findItem(nums1, nums2, r[1], r[2], r[3])
        m = r[3]
        if (l1+l2)%2 == 0:
            if r[1][1] >= l1:
                return (m + nums2[r[2][1]])/2
            elif r[2][1] >= l2:
                return (m + nums1[r[1][1]])/2
            return (m+min(nums1[r[1][1]], nums2[r[2][1]]))/2
        return m
    
    def __findItem(self, nums1, nums2, range1, range2, order):
        n = range1[1]-range1[0]
        m = range2[1]-range2[0]

        if n == 0:
            return True, range1, (range2[0], range2[0]+order+1), nums2[order+range2[0]]
        elif m == 0:
            return True, (range1[0], range1[0]+order+1), range1, nums1[order+range1[0]]
        elif order == n+m-1:
            return True, range1, range2, max(nums1[range1[1]-1], nums2[range2[1]-1])

        index1 = min(n-1, order)+range1[0]
        index2 = bisect_left(nums2, nums1[index1], range2[0], range2[1])
        index = index1-range1[0]+index2-range2[0]
        if index == order:
            return True, (range1[0], index1+1), (range2[0], index2), nums1[index1]
        if index < order:
            return False, (index1+1, range1[1]), (index2, range2[1]), order-index-1
        else:
            return False, (range1[0],index1), (range2[0], index2), order
