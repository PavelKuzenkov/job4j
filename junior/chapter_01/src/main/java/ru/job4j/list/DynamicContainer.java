package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class DynamicContainer.
 * @author Kuzenkov Pavel.
 * @since 02.09.2018.
 */
public class DynamicContainer<E> implements Iterable<E> {

    /**
     * Source array.
     */
    private Object[] container;

    /**
     * Position in source array.
     */
    private int position;

    /**
     * Counting modifications of source array.
     */
    private int modCount;

    /**
     * class constructor.
     */
    public DynamicContainer() {
        this.container = new Object[2];
        this.position = 0;
        this.modCount = 0;
    }

    /**
     * Adding a new object to array.
     * @param value new object.
     */
    public boolean add(E value) {
        if (this.position == this.container.length - 1) {
            this.grow();
        }
        this.container[this.position++] = value;
        return true;
    }

    /**
     * Getting the object in certain position.
     * @param position position.
     * @return object.
     */
    public E get(int position) {
        return (E) this.container[position];

    }

    /**
     * Return size of source array.
     * @return size.
     */
    public int size() {
        return this.container.length;
    }

    /**
     * Increases the capacity.
     */
    private void grow() {
        Object[] newContainer = new Object[this.container.length * 2];
        System.arraycopy(this.container, 0, newContainer, 0, this.container.length);
        this.container = newContainer;
        this.modCount++;
    }


    /**
     * Overriding iterator method.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorDynamicContainer(this.modCount);
    }

    /**
     * Class IteratorDynamicContainer.
     * @author Kuzenkov Pavel.
     * @since 02.09.2018.
     */
    private class IteratorDynamicContainer implements Iterator<E> {

        /**
         * Position in source array.
         */
        private int position = 0;

        /**
         * Expected number of modifications.
         */
        private int expectedModCount;

        /**
         * Class constructor;
         * @param modCount number of modifications.
         */
        public IteratorDynamicContainer(int modCount) {
            this.expectedModCount = modCount;
        }

        /**
         * Overriding hasNext method.
         * @return "true" if iterator has next element, or "false" if not.
         */
        @Override
        public boolean hasNext() {
            this.checkMod();
            boolean result = false;
            if (container.length > this.position) {
                for (int i = this.position; i != container.length; i++) {
                    if (container[i] != null) {
                        result = true;
                        break;
                    }
                }
            }
            return result;
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
                for (int i = this.position; i != container.length; i++) {
                    if (container[i] != null) {
                        result = (E) container[i];
                        this.position = ++i;
                        break;
                    }
                }
            }
            if (result == null) {
                throw new NoSuchElementException();
            }
            return result;
        }

        /**
         * Checking equals number of modifications and expected number of modifications.
         */
        private void checkMod() {
            if (modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

    }
}