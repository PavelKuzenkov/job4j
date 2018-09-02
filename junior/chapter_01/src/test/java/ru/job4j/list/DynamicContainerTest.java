package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicContainerTest {

    private DynamicContainer<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicContainer<>();
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

    @Test (expected = ConcurrentModificationException.class)
    public void whenContainerGrowsThenNextException() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        list.add(2);
        list.add(3);
        iterator.next();
    }

}