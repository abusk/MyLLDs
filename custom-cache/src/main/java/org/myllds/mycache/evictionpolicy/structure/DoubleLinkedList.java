package org.myllds.mycache.evictionpolicy.structure;

public class DoubleLinkedList<K> {
    Node<K> head;
    Node<K> tail;

    public Node<K> removeFirst() {
        Node<K> currentHead = head;
        head = head.next;
        head.prev = null;
        return currentHead;
    }

    public void remove(Node<K> node) {
        if(node == head) {
            head = head.next;
            head.prev = null;
        } else if(node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public Node<K> addLast(Node<K> node) {
        if(head == null) {
            head = node;
            node.prev = null;
        } else if(tail == null) {
            tail = node;
            head.next = tail;
            tail.prev = head;
            tail.next = null;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
        return tail == null ? head : tail;
    }
}
