package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 15.05.2018
 */
public class MatrixTest {

    /**
     * Test multiple 3x3.
     */
    @Test
    public void when3x3() {
         Matrix matrix = new Matrix();
         int[][] result = matrix.multiple(3);
         int[][] exepted = {
                 {1, 2, 3},
                 {2, 4, 6},
                 {3, 6, 9}
         };
         assertThat(result, is(exepted));
    }
}
