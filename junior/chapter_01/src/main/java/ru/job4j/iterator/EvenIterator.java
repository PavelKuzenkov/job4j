package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator.
 * @author Kuzenkov Pavel.
 * @since 17.07.2018.
 */

public class EvenIterator implements Iterator {

    /**
     * Incoming array.
     */
    private final int[] array;

    /**
     * Number of columns.
     */
    int index = 0;

    /**
     * Class constructor.
     * @param array Incoming array.
     */
    public EvenIterator(final int[] array) {
        this.array = array;
    }

    /**
     * Checking the number for parity
     * @param value number.
     * @return "true" if the number is even, or "false" is not.
     */
    private boolean isEven(int value) {
        return  value % 2 == 0 ? true : false;
    }

    /**
     * Overriding hasNext method.
     * @return "true" if array has next even element, or "false" if not.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.array.length > this.index) {
            for (int i = this.index; i != this.array.length; i++) {
                if (this.isEven(this.array[i])) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Overriding next method.
     * @return next even element.
     */
    @Override
    public Object next() throws NoSuchElementException {
        int result = 0;
        if (this.array == null || this.array.length == 0) {
            throw new NoSuchElementException("No such element");
        }
        if (this.hasNext()) {
            for (int i = this.index; i != this.array.length; i++) {
                if (this.isEven(this.array[i])) {
                    result = this.array[i];
                    this.index = ++i;
                    break;
                }
            }
        } else {
            throw new NoSuchElementException("No such element");
        }
        return result;
    }
}
