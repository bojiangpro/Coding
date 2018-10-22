package solution;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class SolutionTest{

    private Solution solution;

    @Before
    public void setUp() throws Exception
    {
        this.solution = new Solution();
    }

    @Test
    public void basicTest()
    {
        test(new int[]{2, 4, 3}, new int[]{5,6,4}, new int[]{7, 0, 8});
        test(new int[]{2, 4, 5,1}, new int[]{5,6,4}, new int[]{7, 0, 0,2});
    }

    private void test(int[] first, int[] second, int[] expected)
    {
        ListNode l1 = createList(first);
        ListNode l2 = createList(second);
        ListNode out = this.solution.addTwoNumbers(l1, l2);

        int[] actuals = createArray(out);
        assertArrayEquals(expected, actuals);
    }

    private static int[] createArray(ListNode node)
    {
        ArrayList<Integer> list = new ArrayList<>();
        while(node != null)
        {
            list.add(node.val);
            node = node.next;
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    private static ListNode createList(int[] values)
    {
        ListNode h = new ListNode(0);
        ListNode f = h;
        for (int v : values) 
        {
            h.next = new ListNode(v);
            h = h.next;
        }
        return f.next;
    }
}