package com.example.bank;
// Java program to demonstrate implementation of our
// own hash table with chaining for collision detection
import java.util.ArrayList;
import java.util.Objects;

// A node of chains
class Node<K, V> {
    K k;
    V acc;
    final int hashCode;


    Node<K, V> next;


    public Node(K key, V value, int hashCode)
    {
        this.k = key;
        this.acc = value;
        this.hashCode = hashCode;
    }
}

// Class to represent entire hash table
class hashtable<K, V> {

    private ArrayList<Node<K, V>> Array;

    private int numBucks;

    // Current size of array list
    private int size;


    public hashtable() {
        Array = new ArrayList<>();
        numBucks = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBucks; i++)
            Array.add(null);
    }
    public ArrayList<V> getValue()
    {

        ArrayList<V> res=new ArrayList<V>();
        for(int i=0 ; i<Array.size() ;i++)
        {
            //System.out.println("kkkkkkkkkkkkkk"+Array.get(i).k);
            Node<K, V> head = Array.get(i);
            while (head != null) {

                    res.add((V) head.acc);

                head = head.next;
            }

        }
        return res;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBucks;
        // key.hashCode() could be negative.
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // Method to remove a given key
    public V remove(K key) {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        // Get head of chain
        Node<K, V> head = Array.get(bucketIndex);

        // Search for key in its chain
       Node<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.k.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            Array.set(bucketIndex, head.next);

        return head.acc;
    }


    public V get(K key) {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        Node<K, V> head = Array.get(bucketIndex);
        while (head != null) {
            if (head.k.equals(key) && head.hashCode == hashCode)
                return head.acc;
            head = head.next;
        }

        // If key not found
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        Node<K, V> head = Array.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.k.equals(key) && head.hashCode == hashCode) {
                head.acc = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = Array.get(bucketIndex);
        Node<K, V> newNode
                = new Node<K, V>(key, value, hashCode);
        newNode.next = head;
        Array.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / numBucks >= 0.7) {
            ArrayList<Node<K, V>> temp = Array;
            Array = new ArrayList<>();
            numBucks = 2 * numBucks;
            size = 0;
            for (int i = 0; i < numBucks; i++)
                Array.add(null);

            for (Node<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.k, headNode.acc);
                    headNode = headNode.next;
                }
            }
        }
    }
}