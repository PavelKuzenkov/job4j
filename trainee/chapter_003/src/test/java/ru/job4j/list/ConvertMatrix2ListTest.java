package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConvertMatrix2ListTest решение задачи части 003 урок 1 4.
 *
 * @author Кузенков Павел.
 * @since 18.06.2018
 */
public class ConvertMatrix2ListTest {

    /**
     * Test toList method.
     */
    @Test
    public void when4on3ArrayThenList12() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},

        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
