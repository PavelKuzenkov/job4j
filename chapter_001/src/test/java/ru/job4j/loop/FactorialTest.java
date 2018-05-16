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
public class FactorialTest {

    /**
     * Test calc n not zero.
     */
    @Test
    public void when5ThenFactorial120() {
         Factorial factorial = new Factorial();
         int result = factorial.calc(5);
         assertThat(result, is(120));
    }

    /**
     * Test calc n = 0.
     */
    @Test
    public void when0ThenFactorial1() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }


}
