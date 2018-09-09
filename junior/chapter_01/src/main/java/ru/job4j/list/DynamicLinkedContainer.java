package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicLinkedContainer.
 * @author Kuzenkov Pavel.
 * @since 04.09.2018.
 */
public class DynamicLinkedContainer<E> implements Iterable<E> {

    /**
     * Size of container.
     */
    private int size;

    /**
     * First element.
     */
    private Node<E> first;

    /**
     * Adding element in the beginning container.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Getting the object in certain position.
     * @param index position.
     * @return object.
     */
    public E get(int index) {
        return this.getNode(index).date;
    }

    /**
     * Getting the node in certain position.
     * @param index position.
     * @return node.
     */
    public Node<E> getNode(int index) {
        this.outOfSize(index);
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * Return size of container.
     * @return size.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Deleting first element.
     */
    public E deleteFirst() {
        E result = this.first.date;
        this.first = this.first.next;
        this.size--;
        return result;
    }

    /**
     * Deleting last element.
     */
    public E deleteLast() {
        E result = this.get(this.size - 1);
        this.size--;
        this.getNode(this.size).next = null;
        return result;
    }

    private void outOfSize(int index) {
        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void cycle(int index) {
        this.outOfSize(index);
        this.getNode(index).next = this.first;
    }

    public boolean hasCycle(Node<E> first) {
        boolean result = false;
        Node<E> temp = first;
        for (int i = 0; i < this.size - 1; i++) {
            for (int j = i; j < this.size - 1; j++) {
                if (first.next == null) {
                    break;
                }
                temp = temp.next;
                if (first == temp) {
                    result = true;
                    break;
                }
            }
            if (result || first.next == null) {
                break;
            }
            first = first.next;
        }
        return result;
    }

    /**
     * Overriding iterator method.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorDynamicLinkedContainer(this.size, this.first);
    }

    /**
     * Class Node.
     * @author Kuzenkov Pavel.
     * @since 04.09.2018.
     */
    private static class Node<E> {

        E date;

        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

    /**
     * Class IteratorDynamicLinkedContainer.
     * @author Kuzenkov Pavel.
     * @since 04.09.2018.
     */
    private class IteratorDynamicLinkedContainer implements Iterator {

        /**
         * Position in source container.
         */
        private Node<E> position;

        /**
         * Expected number of modifications.
         */
        private int expectedSize;

        /**
         * Class constructor;
         * @param size number of modifications.
         */
        public IteratorDynamicLinkedContainer(int size, Node<E> position) {
            this.expectedSize = size;
            this.position = position;
        }

        /**
         * Overriding hasNext method.
         * @return "true" if iterator has next element, or "false" if not.
         */
        @Override
        public boolean hasNext() {
            this.checkMod();
            return this.position != null;
        }

        /**
         * Overriding next method.
         * @return next element.
         */
        @Override
        public E next() {
            this.checkMod();
            E result = null;
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                result = this.position.date;
                this.position = this.position.next;
            }
            return result;
        }

        /**
         * Checking equals number of modifications and expected number of modifications.
         */
        private void checkMod() {
            if (size != this.expectedSize) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
