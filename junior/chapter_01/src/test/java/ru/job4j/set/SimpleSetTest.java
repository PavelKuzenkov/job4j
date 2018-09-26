package ru.job4j.set;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    private SimpleSet<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleSet<>();
        list.add(1);
    }
    @Test
    public void whenAddElementsThenContainerGrows() {
        assertThat(list.size(), is(2));
        list.add(2);
        list.add(3);
        assertThat(list.size(), is(4));
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        list.add(2);
        assertThat(list.get(1), is(2));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenContainerGrowsThenHasNextException() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        list.add(2);
        list.add(3);
        iterator.hasNext();
    }

    @Test
    public void whenAddDuplicateThenFalse() {
        boolean result1 = list.add(2);
        boolean result2 = list.add(3);
        boolean result3 = list.add(2);
        boolean result4 = list.add(3);
        boolean result5 = list.add(4);
        assertThat(list.size(), is(8));
        assertThat(result1, is(true));
        assertThat(result2, is(true));
        assertThat(result3, is(false));
        assertThat(result4, is(false));
        assertThat(result5, is(true));
    }
}
