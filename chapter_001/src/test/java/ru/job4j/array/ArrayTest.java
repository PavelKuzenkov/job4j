package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 14.05.2018
 */
public class ArrayTest {

    /**
     * Test calculate bound 3.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(result, is(expect));
    }

    /**
     * Test calculate bound 5.
     */
    @Test
    public void whenBound5Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(result, is(expect));
    }
}
