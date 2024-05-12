package org.myllds.mycache.evictionpolicy.structure;

import org.myllds.mycache.exception.DLLException;

public class DoubleLinkedList<K> {
    Node<K> head;
    Node<K> tail;

    public synchronized Node<K> removeFirst() {
        Node<K> currentHead = head;
        head = head.next;
        head.prev = null;
        return currentHead;
    }

    public synchronized void remove(Node<K> node) throws DLLException {
        if (node == null) {
            throw new DLLException("Node to remove can't be NULL. ");
        }
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

    public synchronized Node<K> addLast(Node<K> node) {
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
