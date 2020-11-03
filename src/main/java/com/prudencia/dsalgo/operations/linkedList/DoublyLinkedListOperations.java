package com.prudencia.dsalgo.operations.linkedList;

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


    /* Given a node as prev_node, insert a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data)
    {

        /*1. check if the given prev_node is NULL */
        if (prev_Node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node new_node = new Node(new_data);

        /* 4. Make next of new node as next of prev_node */
        new_node.next = prev_Node.next;

        /* 5. Make the next of prev_node as new_node */
        prev_Node.next = new_node;

        /* 6. Make prev_node as previous of new_node */
        new_node.prev = prev_Node;

        /* 7. Change previous of new_node's next node */
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }

    // Function to delete a node in a Doubly Linked List.
    // head_ref --> pointer to head node pointer.
    // del --> data of node to be deleted.
    public void deleteNode(Node del)
    {

        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
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
        doublyLinkedListOperations.InsertAfter(doublyLinkedListOperations.head.next.next,11);
        doublyLinkedListOperations.printList();
        doublyLinkedListOperations.deleteNode(doublyLinkedListOperations.head.next.next.next.next);
        doublyLinkedListOperations.printList();

    }
}
