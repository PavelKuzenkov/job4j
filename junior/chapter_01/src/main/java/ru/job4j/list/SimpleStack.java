package ru.job4j.list;

/**
 * Class SimpleStack.
 * @author Kuzenkov Pavel.
 * @since 08.09.2018.
 */
public class SimpleStack<E> extends DynamicLinkedContainer<E> {

    public E poll() {
        return super.deleteFirst();

    }

    public void push(E value) {
        super.add(value);
    }
}
