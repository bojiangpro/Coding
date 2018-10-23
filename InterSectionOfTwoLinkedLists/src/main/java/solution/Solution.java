package solution;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int d = lenA - lenB;
        headA = walk(headA, d);
        headB = walk(headB, -d);
        while(headA != null)
        {
            if(headA == headB)
            {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static ListNode walk(ListNode head, int step)
    {
        for (int i = 0; i < step; i++) {
            head = head.next;
        }
        return head;
    }

    private static int getLength(ListNode head)
    {
        int l = 0;
        while (head != null) {
            head = head.next;
            l++;
        }
        return l;
    }
}