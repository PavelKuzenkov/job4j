package ru.job4j.set;

import ru.job4j.list.DynamicContainer;

/**
 * Class SimpleSet.
 * @author Kuzenkov Pavel.
 * @since 26.09.2018.
 */
public class SimpleSet<E> extends DynamicContainer<E> {

    /**
     * Overriding add method.
     * @param value new object.
     * @return "true" if added or "false" if not.
     */
    @Override
    public boolean add(E value) {
        boolean result = false;
        if (!super.has(value)) {
            super.add(value);
            result = true;
        }
        return result;
    }
}
