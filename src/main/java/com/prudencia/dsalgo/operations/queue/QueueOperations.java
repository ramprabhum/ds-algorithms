package com.prudencia.dsalgo.operations.queue;

import java.util.ArrayList;

public class QueueOperations {
}
// Java program to implement a queue using an array
class Queue {
    private static int front, rear, capacity;
    private static int queue[];

    Queue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }

    // function to insert an element
    // at the rear of the queue
    static void queueEnqueue(int data)
    {
        // check queue is full or not
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }

        // insert element at the rear
        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }

    // function to delete an element
    // from the front of the queue
    static void queueDequeue()
    {
        // if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        }

        // shift all the elements from index 2 till rear
        // to the right by one
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
        return;
    }

    // print queue elements
    static void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.printf(" %d <-- ", queue[i]);
        }
        return;
    }

    // print front of queue
    static void queueFront()
    {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }
}

 class Queueinjava {

    // Driver code
    public static void main(String[] args)
    {
        // Create a queue of capacity 4
        Queue q = new Queue(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }

}

class CircularQueue{

    // Declaring the class variables.
    private int size, front, rear;

    // Declaring array list of integer type.
    private ArrayList<Integer> queue = new ArrayList<Integer>();

    // Constructor
    CircularQueue(int size)
    {
        this.size = size;
        this.front = this.rear = -1;
    }

    // Method to insert a new element in the queue.
    public void enQueue(int data)
    {

        // Condition if queue is full.
        if((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1)))
        {
            System.out.print("Queue is Full");
        }

        // condition for empty queue.
        else if(front == -1)
        {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        }

        else if(rear == size - 1 && front != 0)
        {
            rear = 0;
            queue.set(rear, data);
        }

        else
        {
            rear = (rear + 1);

            // Adding a new element if
            if(front <= rear)
            {
                queue.add(rear, data);
            }

            // Else updating old value
            else
            {
                queue.set(rear, data);
            }
        }
    }

    // Function to dequeue an element
// form th queue.
    public int deQueue()
    {
        int temp;

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");

            // Return -1 in case of empty queue
            return -1;
        }

        temp = queue.get(front);

        // Condition for only one element
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }

        else if(front == size - 1)
        {
            front = 0;
        }
        else
        {
            front = front + 1;
        }

        // Returns the dequeued element
        return temp;
    }

    // Method to display the elements of queue
    public void displayQueue()
    {

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            return;
        }

        // If rear has not crossed the max size
        // or queue rear is still greater then
        // front.
        System.out.print("Elements in the " +
                "circular queue are: ");

        if(rear >= front)
        {

            // Loop to print elements from
            // front to rear.
            for(int i = front; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }

        // If rear crossed the max index and
        // indexing has started in loop
        else
        {

            // Loop for printing elements from
            // front to max size or last index
            for(int i = front; i < size; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }

            // Loop for printing elements from
            // 0th index till rear position
            for(int i = 0; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args)
    {

        // Initialising new object of
        // CircularQueue class.
        CircularQueue q = new CircularQueue(5);

        q.enQueue(14);
        System.out.print("front "+q.front+ " rear" +q.rear);

        q.enQueue(22);
        System.out.print("front "+q.front+ " rear" +q.rear);


        q.enQueue(13);
        System.out.print("front "+q.front+ " rear" +q.rear);

        q.enQueue(-6);
        System.out.print("front "+q.front+ " rear" +q.rear);


        q.displayQueue();

        int x = q.deQueue();

        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        x = q.deQueue();

        // Checking for empty queue.
        if(x != -1)
        {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        q.displayQueue();

        q.enQueue(9);
        System.out.print("front "+q.front+ " rear" +q.rear);

        q.enQueue(20);
        System.out.print("front "+q.front+ " rear" +q.rear);

        q.enQueue(5);
        System.out.print("front "+q.front+ " rear" +q.rear);


        q.displayQueue();





    }
}

