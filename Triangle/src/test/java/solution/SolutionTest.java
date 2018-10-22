package solution;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest
{
    private Solution solution;

    @Before
    public void setUp()
    {
        this.solution = new Solution();
    }

    @Test
    public void basicTest()
    {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        int actual = this.solution.minimumTotal(triangle);
        assertEquals(11, actual);
    }
}