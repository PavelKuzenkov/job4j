package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 13.05.2018
 */
public class CounterTest {

    /**
     * Test add
     */
    @Test
    public void whenStart1Finish10Then30() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}
