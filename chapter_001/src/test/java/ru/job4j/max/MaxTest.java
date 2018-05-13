package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 13.05.2018
 */

public class MaxTest {

    /**
     * Test max first.
     */@Test
    public void whenFirstLessSecond() {
         Max max = new Max();
         int result = max.max(1, 2);
         assertThat(result, is(2));
    }

    /**
     * Test max second.
     */@Test
    public void whenSecondLessFirst() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

}
