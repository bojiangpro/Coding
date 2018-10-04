from bisect import bisect_left

class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        length = len(nums)
        zipped = zip(nums, range(length))
        zipped = sorted(zipped, key=lambda t: t[0])
        nums, indices = zip(*zipped)
        low, high = 0, length-1
        if target == nums[low]+nums[high]:
            return [indices[low], indices[high]]
        while low < high:
            t = target-nums[low]
            high = bisect_left(nums, t, low+1, high)
            if nums[high] == t:
                return [indices[low], indices[high]]
            
            t = target-nums[high]
            low = bisect_left(nums, t, low+1, high)
            if nums[low] == t:
                return [indices[low], indices[high]]