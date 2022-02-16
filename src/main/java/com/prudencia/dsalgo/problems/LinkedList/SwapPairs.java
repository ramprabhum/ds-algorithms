package com.prudencia.dsalgo.problems.LinkedList;


import com.prudencia.dsalgo.operations.linkedList.LinkedListOperations;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;
        System.out.print("prev Node ");
        printList(prevNode);

        while(head!=null && head.next!=null){

            ListNode firstNode=head;
            ListNode secondNode = head.next;
            System.out.println("******PrevNode "+prevNode.val);
            System.out.println("FirstNode "+firstNode.val +" SecondNode " + secondNode.val);

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            if(prevNode.next !=null)
                System.out.print(" prevNode.next "+prevNode.next.val);
            if(firstNode.next !=null)
                System.out.print(" firstNode.next "+firstNode.next.val);
            if(secondNode.next !=null)
                System.out.print(" SecondNode.next " + secondNode.next.val);
            System.out.println(" prevNode "+prevNode.val);
            prevNode=firstNode;
            head = firstNode.next;
            System.out.print(" prevNode ---- "+ prevNode.val);
            if(prevNode.next !=null)
            System.out.print("  prevNode Next ---- "+ prevNode.next.val);
            System.out.println();

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode Ln = new ListNode(1);
        Ln.next = new ListNode(2);
        Ln.next.next = new ListNode(3);
        Ln.next.next.next = new ListNode(4);
        ListNode result = swapPairs.swapPairs(Ln);
        printList(result);

    }

    public static void printList(ListNode ln)
    {
        ListNode tnode = ln;
        while (tnode != null)
        {
            System.out.print(tnode.val+" ");
            tnode = tnode.next;
        }
        System.out.println();
    }
}
