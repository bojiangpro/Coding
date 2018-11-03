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

    public int[] find2DPeakElement(int[][] nums) {
        int l = 0;
        int h = nums.length - 1;
        int mid = h/2;
        while(l < h)
        {
            int m = findMaxElement(nums[mid]);
            if(nums[mid][m]<nums[mid+1][m])
            {
                l = mid+1;
            }
            else
            {
                h = mid;
            }
            mid = (l+h)/2;
        }

        return new int[] {l, findMaxElement(nums[l])};
    }

    private static int findMaxElement(int[] nums){
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[max])
            {
                max = i;
            }
        }
        return max;
    }
}