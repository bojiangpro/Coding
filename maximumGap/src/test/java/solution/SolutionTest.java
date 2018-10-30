package solution;

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
        test(new int[]{3,6,9,1}, 3);
    }

    private void test(int[] nums, int expected)
    {
        int g = this.solution.maximumGap(nums);
        assertEquals(expected, g);
    }
}