package solution;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest{

    private Solution solution;
    private ListNode[] nodes;

    @Before
    public void setUp()
    {
        this.solution = new Solution();
        this.nodes = new ListNode[100];
        for (int i = 0; i < 100; i++) {
            this.nodes[i] = new ListNode(i);
        }
    }

    @Test
    public void basicTest()
    {
        test(new int[]{1,3,5,7,9,11,13,15,17,19,21}, new int[]{2}, null);
        setUp();
        test(new int[]{2, 4, 5,1}, new int[]{5,1}, 5);
    }

    private void test(int[] first, int[] second, Integer expected)
    {

        ListNode l1 = createList(first);
        ListNode l2 = createList(second);
        ListNode out = this.solution.getIntersectionNode(l1, l2);
        ListNode node = expected == null ? null : this.nodes[expected];
        assertEquals(node, out);
    }

    private ListNode createList(int[] values)
    {
        ListNode h = new ListNode(0);
        ListNode f = h;
        for (int v : values) 
        {
            h.next = this.nodes[v];
            h = h.next;
        }
        return f.next;
    }
}