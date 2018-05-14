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

public class BoardTest {

    /**
     * Test paint 3x3.
     */@Test
    public void when3x3() {
         Board board = new Board();
         String result = board.paint(3, 3);
         String ln = System.getProperty("line.separator");
         String expected = String.format("x x%s x %sx x%s", ln, ln, ln);
         assertThat(result, is(expected));
    }

    /**
     * Test paint 5x4.
     */@Test
    public void when5x4() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String ln = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", ln, ln, ln, ln);
        assertThat(result, is(expected));
    }
}
