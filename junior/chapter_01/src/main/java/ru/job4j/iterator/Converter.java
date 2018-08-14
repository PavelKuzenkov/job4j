package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter.
 * @author Kuzenkov Pavel.
 * @since 14.08.2018.
 */
public class Converter {

    /**
     * Converting iterator of iterators to iterator.
     * @param it incoming iterator of iterators.
     * @return iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            /**
             * Inside iterator.
             */
            private Iterator<Integer> temp = it.next();

            /**
             * Checking, have we more not empty iterator.
             * @return "true" if we have more not empty iterator, or "false" if not.
             */
            private boolean hasMoreNotEmptyIterators() {
                boolean result = false;
                boolean isEmpty = false;
                do {
                    if (it.hasNext()) {
                        this.temp = it.next();
                        if (this.temp.hasNext()) {
                            result = true;
                            isEmpty = false;
                        }
                    }
                } while (isEmpty);
                return result;
            }

            /**
             * Overriding hasNext method.
             * @return "true" if iterator has next element, or "false" if not.
             */
            @Override
            public boolean hasNext() {
               return this.temp.hasNext() || hasMoreNotEmptyIterators();
            }

            /**
             * Overriding next method.
             * @return next even element.
             */
            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException("No such element");
                } else {
                    if (this.temp.hasNext()) {
                        return temp.next();
                    } else {
                        this.temp = it.next();
                        return this.temp.next();
                    }
                }
            }
        };
    }
}
