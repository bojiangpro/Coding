# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
    

from heapq import heappush, heappop, heapify

class Comparable:
    def __init__(self, x):
        self.element = x
    def __lt__(self, x):
        return self.element.val < x.element.val

class Solution:
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = ListNode(0)
        node = head
        h = [Comparable(n) for n in lists if n]
        
        heapify(h)
        
        while len(h) > 0:
            n = heappop(h)
            node.next = n.element
            node = node.next
            if node.next:
                heappush(h, Comparable(node.next))
        return head.next
