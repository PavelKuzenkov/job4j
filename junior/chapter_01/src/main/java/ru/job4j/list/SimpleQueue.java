package ru.job4j.list;

/**
 * Class SimpleQueue.
 * @author Kuzenkov Pavel.
 * @since 08.09.2018.
 */
public class SimpleQueue<E> extends DynamicLinkedContainer<E> {

    public E poll() {
        return super.deleteLast();
    }

    public void push(E value) {
        super.add(value);
    }
}
