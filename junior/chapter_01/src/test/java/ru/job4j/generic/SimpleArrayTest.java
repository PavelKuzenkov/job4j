package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleArray<Integer> simple = new SimpleArray<Integer>(4);
        simple.add(2);
        int result = simple.get(0);
        assertThat(result, is(2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenArrayIsFullThenException() {
        SimpleArray<Integer> simple = new SimpleArray<Integer>(4);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        simple.add(5);
    }

    @Test
    public void set() {
        SimpleArray<Integer> simple = new SimpleArray<Integer>(4);
        simple.add(1);
        simple.set(0, 2);
        int result = 2;
        assertThat(result, is(2));
    }

    @Test
    public void delete() {
        SimpleArray<String> simple = new SimpleArray<String>(5);
        simple.add("1");
        simple.add("2");
        simple.add("3");
        simple.add("4");
        simple.add("5");
        simple.delete(1);
        String result1 = simple.get(0);
        String result2 = simple.get(1);
        String result3 = simple.get(2);
        String result4 = simple.get(3);
        assertThat(result1, is("1"));
        assertThat(result2, is("3"));
        assertThat(result3, is("4"));
        assertThat(result4, is("5"));
    }
}