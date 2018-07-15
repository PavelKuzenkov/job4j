package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 23.05.2018
 */
public class RotateArrayTest {

    /**
     * Test rotate 4x4
     */
    @Test
    public void whenArray4x4ThenRotateArray() {
        RotatedArray rotatedArray = new RotatedArray();
        int[][] input = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        int[][] result = rotatedArray.rotate(input);
        int[][] expected = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };
        assertThat(result, is(expected));
    }

    /**
     * Test rotate 5x5
     */
    @Test
    public void whenArray5x5ThenRotateArray() {
        RotatedArray rotatedArray = new RotatedArray();
        int[][] input = {
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };
        int[][] result = rotatedArray.rotate(input);
        int[][] expected = {
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}
        };
        assertThat(result, is(expected));
    }
}

