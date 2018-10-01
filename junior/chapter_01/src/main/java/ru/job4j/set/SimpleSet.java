package ru.job4j.set;

import ru.job4j.list.DynamicContainer;

import java.util.Iterator;

/**
 * Class SimpleSet.
 * @author Kuzenkov Pavel.
 * @since 26.09.2018.
 */
public class SimpleSet<E> {

    /**
     * Data container.
     */
    private DynamicContainer<E> container = new DynamicContainer<>();

    /**
     * Overriding add method.
     * @param value new object.
     * @return "true" if added or "false" if not.
     */
    public boolean add(E value) {
        boolean result = false;
        if (!this.container.has(value)) {
            this.container.add(value);
            result = true;
        }
        return result;
    }

    /**
     * Getting the object in certain position.
     * @param position position.
     * @return object.
     */
    public E get(int position) {
        return this.container.get(position);
    }

    /**
     * Return size of source array.
     * @return size.
     */
    public int size() {
        return this.container.size();
    }

    /**
     * Overriding iterator method.
     * @return iterator.
     */
    public Iterator<E> iterator() {
        return this.container.iterator();
    }
}
