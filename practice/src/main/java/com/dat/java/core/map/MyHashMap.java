package com.dat.java.core.map;

public class MyHashMap <K, V>{
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private Node<K, V>[] table;

    public MyHashMap() {

    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Node<K, V>[]) new Node[capacity];
    }

    private static class Node<K,V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<>(key, value, table[index]);
        table[index] = newNode;
        size++;
        if (size > capacity * loadFactor) {
            resize();
        }
    }

    public V get(K key) {

    }

    public void remove(K key) {

    }

    private void resize() {

    }
}
