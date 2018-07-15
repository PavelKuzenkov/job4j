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
public class ArrayDuplicateTest {

    /**
     * Test remote.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
         ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
         String[] input = {"Привет", "Привет", "Привет", "Привет", "Мир", "Привет", "Супер", "Мир", "Привет", "Привет", "Мир", "Супер", "Супер", "Супер"};
         String[] result = arrayDuplicate.remote(input);
         String[] expected = {"Привет", "Мир", "Супер"};
         assertThat(result, is(expected));
     }
}
