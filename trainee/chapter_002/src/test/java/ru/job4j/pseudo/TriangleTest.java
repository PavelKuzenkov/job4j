package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 31.05.2018
 */
public class TriangleTest {

    /**
     * Test draw method.
     */
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("+   ")
                                .append("++  ")
                                .append("+ + ")
                                .append("++++")
                                .toString()
                )
        );
    }
}