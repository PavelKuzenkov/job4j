package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorArray.
 * @author Kuzenkov Pavel.
 * @since 15.07.2018.
 */
public class IteratorArray implements Iterator {

    /**
     * Incoming array.
     */
    private final int[][] array;

    /**
     * Number of columns.
     */
    int column = 0;

    /**
     * Number or ranges.
     */
    int range = 0;

    /**
     * Class constructor.
     * @param array Incoming array.
     */
    public IteratorArray(final int[][] array) {
        this.array = array;
    }


    /**
     * Overriding hasNext method.
     * @return "true" if array has next element, or "false" if not.
     */
    @Override
    public boolean hasNext() throws ArrayIndexOutOfBoundsException {
        boolean result = false;
        if (this.array[range].length > column) {
            result = true;
        }
        if (this.array[range].length == column) {
            try {
                if (this.array[range + 1].length > 0) {
                    result = true;
                }
            } catch (ArrayIndexOutOfBoundsException aiob) {
                System.out.println("The array is finished");
                result = false;
            }
        }
        return result;
    }

    /**
     * Overriding next method.
     * @return next element.
     */
    @Override
    public Object next() throws NoSuchElementException {
        Object result;
        if (this.array == null || this.array.length == 0) {
            throw new NoSuchElementException("No such element");
        }
        if (this.array[range].length == column && this.hasNext()) {
            range++;
            column = 0;
        }
            if (this.hasNext()) {
                result = this.array[range][column++];
            } else {
                throw new NoSuchElementException("No such element");
            }
        return result;
    }
}
