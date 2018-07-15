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
public class BubbleSortTest {

    /**
     *Test sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
         BubbleSort bubbleSort = new BubbleSort();
         int[] input = new int[] {13, 18, 2, 1, 48, 6, 3, 25, 4, 18};
         int[] result = bubbleSort.sort(input);
         int[] exepted = {1, 2, 3, 4, 6, 13, 18, 18, 25, 48};
         assertThat(result, is(exepted));
    }
}
