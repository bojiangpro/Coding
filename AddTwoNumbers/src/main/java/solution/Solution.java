package solution;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode trail = head;
        while(l1 != null || l2 != null)
        {
            if (l1 == null)
            {
                l1 = new ListNode(0);
            }
            else if (l2 == null)
            {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum%10);
            trail.next = node;
            trail= node;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry == 1)
        {
            trail.next = new ListNode(carry);
        }

        return head.next;
    }
}