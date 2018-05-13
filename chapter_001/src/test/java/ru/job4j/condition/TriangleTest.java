package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 13.05.2018
 */

public class TriangleTest {

    /**
     * Test area.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2d;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Test period.
     */
    @Test
    public void whenAreaSetThreePointsThenTrianglePerimeter() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.period(2, 2, 2.8);
        double expected = 3.4;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Test exist.
     */
    @Test
    public void whenEachSideLessAmountOtherSides() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        boolean resalt = triangle.exist(2, 2, 2.8);
        assertThat(resalt, is(true));
    }
}