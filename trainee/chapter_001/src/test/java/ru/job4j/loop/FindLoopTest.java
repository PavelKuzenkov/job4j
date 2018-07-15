package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 14.05.2018
 */
public class FindLoopTest {

    /**
     * Test findLoop find.
     */
    @Test
    public void whenWeWantFind5Then0() {
         FindLoop findLoop = new FindLoop();
         int[] input = new int[] {5, 23, 10};
         int value = 5;
         int expected = 0;
         int result = findLoop.indexOf(input, value);
         assertThat(expected, is(result));
    }

    /**
     * Test findLoop not find.
     */
    @Test
    public void whenWeWantFind5ThenNotFind() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[] {5, 23, 10};
        int value = 8;
        int expected = -1;
        int result = findLoop.indexOf(input, value);
        assertThat(expected, is(result));
    }
}
