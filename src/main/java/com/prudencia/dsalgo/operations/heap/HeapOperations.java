package com.prudencia.dsalgo.operations.heap;

public class HeapOperations {
    public static void main(String[] args) {

        System.out.println("The Max Heap is ");
        MinMaxHeap maxHeap = new MinMaxHeap(15, true);
        maxHeap.insertMax(5);
        maxHeap.insertMax(3);
        maxHeap.insertMax(17);
        maxHeap.insertMax(10);
        maxHeap.insertMax(84);
        maxHeap.insertMax(19);
        maxHeap.insertMax(6);
        maxHeap.insertMax(22);
        maxHeap.insertMax(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());



        System.out.println("The Min Heap is ");
        MinMaxHeap minHeap = new MinMaxHeap(15,false);
        minHeap.insertMin(5);
        minHeap.insertMin(3);
        minHeap.insertMin(17);
        minHeap.insertMin(10);
        minHeap.insertMin(84);
        minHeap.insertMin(19);
        minHeap.insertMin(6);
        minHeap.insertMin(22);
        minHeap.insertMin(9);
        minHeap.minHeap();

        minHeap.print();
        minHeap.insertMinAt(1,3);
        System.out.println("The Min Heap is ");

        minHeap.print();
        System.out.println("The Min val is " + minHeap.removeMin());
    }
}
class MinMaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity.
    public MinMaxHeap(int maxsize,boolean max)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        if(max)
            Heap[0] = Integer.MAX_VALUE;
        else
            Heap[0]= Integer.MIN_VALUE;
    }

    // Returns position of parent
    private int parent(int pos)
    {
        return pos / 2;
    }

    // Below two functions return left and
    // right children.
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Returns true of given node is leaf
    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] ||
                Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Inserts a new element to max heap
    public void insertMax(int element)
    {
        Heap[++size] = element;

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Inserts a new element to max heap
    public void insertMinAt(int element, int position)
    {
        Heap[position] = element;

        while (position > 0 &&  Heap[parent(position)] > Heap[position] ) {
            swap(position, parent(position));
            position = parent(position);
        }
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " +
                    Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Remove an element from max heap
    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }

    // Function to insert a node into the heap
    public void insertMin(int element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swapMin(current, parent(current));
            current = parent(current);
        }
    }



    // Function to build the min heap using
    // the minHeapify
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to swap two nodes of the heap
    private void swapMin(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to remove and return the minimum
    // element from the heap
    public int removeMin()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

}
