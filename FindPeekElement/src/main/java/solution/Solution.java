package solution;

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int mid = h/2;
        while(l < h)
        {
            if(nums[mid]<nums[mid+1])
            {
                l = mid+1;
            }
            else
            {
                h = mid;
            }
            mid = (l+h)/2;
        }
        return l;
    }
}