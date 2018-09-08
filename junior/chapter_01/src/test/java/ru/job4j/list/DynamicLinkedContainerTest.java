package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicLinkedContainerTest {

    private DynamicLinkedContainer<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicLinkedContainer<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirstElementThenUseGetResultTwo() {
        assertThat(list.deleteFirst(), is(3));
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(2));
        assertThat(list.get(1), is(1));
    }

    @Test
    public void whenDeleteLastElementThenUseGetResultTwo() {
        assertThat(list.deleteLast(), is(1));
        assertThat(list.getSize(), is(2));
        assertThat(list.get(0), is(3));
        assertThat(list.get(1), is(2));
    }

    @Test
    public void nextAndHasNextWhenSeveralElements() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void nextAndHasNextWhenOneElement() {
        list.deleteFirst();
        list.deleteFirst();
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void nextAndHasNextWhenNoElements() {
        list.deleteFirst();
        list.deleteFirst();
        list.deleteFirst();
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenContainerGrowsThenHasNextException() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        list.add(4);
        list.add(5);
        iterator.hasNext();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenContainerGrowsThenNextException() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        list.add(4);
        list.add(5);
        iterator.next();
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNoMoreElementsThenException() {
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

}