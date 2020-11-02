package com.prudencia.dsalgo.linkedList;

public class DoublyLinkedListOperations {
    DoublyLinkedListOperations.Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        DoublyLinkedListOperations.Node prev;
        DoublyLinkedListOperations.Node next;
        Node(int d) {data = d; next = null; prev=null; }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        Node tNode = new Node(new_data);

        tNode.next = head;
        tNode.prev= null;

        if (head != null)
            head.prev = tNode;

        head = tNode;

    }

    /* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
    public void append(int new_data)
    {
        Node tNode = new Node(new_data);

        if(head == null) {
            head = tNode;
            return;
        }

        tNode.next = null;
        Node last = head;
        while(last.next != null) {
                  last= last.next;
        }
        last.next = tNode;
        tNode.prev = last;

    }

    /* This function prints contents of doubly linked list starting from
    the given node */
    public void printList()
    {
        DoublyLinkedListOperations.Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DoublyLinkedListOperations doublyLinkedListOperations = new DoublyLinkedListOperations();

        doublyLinkedListOperations.append(0);
        doublyLinkedListOperations.push(1);
        doublyLinkedListOperations.push(2);
        doublyLinkedListOperations.append(6);
        doublyLinkedListOperations.push(3);
        doublyLinkedListOperations.append(5);
        doublyLinkedListOperations.printList();

    }
}
