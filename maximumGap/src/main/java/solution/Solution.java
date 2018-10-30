package solution;

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
        {
            return 0;
        }
        int min = nums[0];
        int max = min;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            if (min > v)
            {
                min = v;
            }
            else if(max < v)
            {
                max = v;
            }
        }

        double interval = (max-min)/(nums.length-1.0);
        int[][] blocks = new int[nums.length][];
        for (int v : nums) {
            int i = (int)((v-min)/interval);
            int[] b = blocks[i];
            if(b == null)
            {
                blocks[i] = new int[]{v, v};
            }
            else
            {
                if(v < b[0])
                {
                    b[0] = v;
                }
                else if(v > b[1])
                {
                    b[1] = v;
                }
            }
        }
        int maxGap = 0;
        int lastMax = blocks[0][1];
        for (int i = 1; i < nums.length; i++) {
            int[] b = blocks[i];
            if(b != null)
            {
                int gap = b[0]-lastMax;
                if(gap > maxGap)
                {
                    maxGap = gap;
                }
                lastMax = b[1];
            }
        }
        return maxGap;
    }

}