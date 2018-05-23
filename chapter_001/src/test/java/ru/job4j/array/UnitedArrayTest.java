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
public class UnitedArrayTest {

    /**
     * Test union array.
     */
    @Test
    public void whenTwoArraysThenOneSortedArray() {
        UnitedArrays unitedArrays = new UnitedArrays();
        int[] input1 = {1, 5, 6, 7, 10};
        int[] input2 = {2, 8, 9, 11, 15, 22, 75};
        int[] exepted = {1, 2, 5, 6, 7, 8, 9, 10, 11, 15, 22, 75};
        int[] result = unitedArrays.union(input1, input2);
        assertThat(result, is(exepted));

    }
}
