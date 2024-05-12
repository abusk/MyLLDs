package org.myllds.mycache.evictionpolicy.structure;

public class Node<T> {
    public T key;
    public Node<T> next;
    public Node<T> prev;
    public Node(T key) {
        this.key = key;
    }
}
