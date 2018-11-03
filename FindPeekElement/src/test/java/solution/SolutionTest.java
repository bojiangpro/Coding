package solution;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest{

    private Solution solution;
    @Before
    public void setUp()
    {
        this.solution = new Solution();
    }

    @Test
    public void basicTest()
    {
        test(new int[]{1,3,5,7,9,11,16,15,14,13,12}, 6);
        test(new int[][]{{2, 4, 5, 1}, 
                         {1, 7, 6, 2},
                         {3, 4, 5, 1} }, new int []{1, 1});
    }

    private void test(int[] nums, int expected)
    {
        int max = this.solution.findPeakElement(nums);
        assertEquals(max, expected);
    }

    private void test(int[][] nums, int[] expected)
    {
        int[] max = this.solution.find2DPeakElement(nums);
        assertArrayEquals(max, expected);
    }
}