package com.prudencia.dsalgo.operations.linkedList;

public class CircularLinkedListOperations {

        static class Node
        {
            int data;
            Node next;
        };

    public Node addToEmpty(Node last, int data)
    {
        // This function is only for empty list
        if (last != null)
            return last;

        // Creating a node dynamically.
        Node temp = new Node();

        // Assigning the data.
        temp.data = data;
        last = temp;

        // Creating the link.
        last.next = last;

        return last;
    }
    public Node addBegin(Node last, int data)
    {
        if (last == null)
            return addToEmpty(last, data);

        Node temp = new Node();

        temp.data = data;
        temp.next = last.next;
        last.next = temp;

        return last;
    }

    public Node addEnd(Node last, int data)
    {
        if (last == null)
            return addToEmpty(last, data);

        Node temp = new Node();

        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        last = temp;

        return last;
    }

    public Node addAfter(Node last, int data, int item)
    {
        if (last == null)
            return null;

        Node temp, p;
        p = last.next;
        do
        {
            if (p.data == item)
            {
                temp = new Node();
                temp.data = data;
                temp.next = p.next;
                p.next = temp;

                if (p == last)
                    last = temp;
                return last;
            }
            p = p.next;
        } while(p != last.next);

        System.out.println(item + " not present in the list.");
        return last;

    }

    public void traverse(Node last)
    {
        Node p;

        // If list is empty, return.
        if (last == null)
        {
            System.out.println("List is empty.");
            return;
        }

        // Pointing to first Node of the list.
        p = last.next;

        // Traversing the list.
        do
        {
            System.out.print(p.data + " ");
            p = p.next;

        }
        while(p != last.next);

        System.out.println();


    }

    public static void main(String[] args) {
        CircularLinkedListOperations circularLinkedListOperations = new CircularLinkedListOperations();

        Node last = null;
        last =circularLinkedListOperations.addToEmpty(last,2);
        last= circularLinkedListOperations.addEnd(last,8);
        circularLinkedListOperations.traverse(last);
        last= circularLinkedListOperations.addBegin(last,3);
        circularLinkedListOperations.traverse(last);
        last= circularLinkedListOperations.addEnd(last,4);
        last = circularLinkedListOperations.addAfter(last,5,2);
        circularLinkedListOperations.traverse(last);

    }
}
