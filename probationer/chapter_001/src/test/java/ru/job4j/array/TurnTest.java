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
public class TurnTest {

    /**
     * Test even amount.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
         Turn turn = new Turn();
         int[] input = new int[] {1, 2, 3, 4};
         int[] result = turn.turn(input);
         int[] expected = new int[] {4, 3, 2, 1};
         assertThat(result, is(expected));
    }

    /**
     * Test not even amount.
     */
    @Test
    public void whenTurnArrayWithNotEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] input = new int[] {2, 5, 10, 21, 42};
        int[] result = turn.turn(input);
        int[] expected = new int[] {42, 21, 10, 5, 2};
        assertThat(result, is(expected));
    }
}
