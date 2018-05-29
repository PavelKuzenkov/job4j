package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 26.05.2018
 */
public class TrackerTest {

    /**
     * Test add, generateId and getAll methods.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * Test replace method.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test delete and getAll method.
     */
    @Test
    public void whenDeleteItemThenReturnWithoutItem() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test1", "testDescription1", 123L);
        Item test2 = new Item("test2", "testDescription2", 1234L);
        Item test3 = new Item("test3", "testDescription3", 1235L);
        Item test4 = new Item("test4", "testDescription4", 1236L);
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        Item[] result = tracker.getAll();
        assertThat(result[0], is(test1));
        assertThat(result[1], is(test2));
        assertThat(result[2], is(test3));
        assertThat(result[3], is(test4));
        tracker.delete(test2.getId());
        result = tracker.getAll();
        assertThat(result[0], is(test1));
        assertThat(result[1], is(test3));
        assertThat(result[2], is(test4));
    }

    /**
     * Test findById method.
     */
    @Test
    public void whenFindByIdThenReturnSameName() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test1", "testDescription1", 123L);
        Item test2 = new Item("test2", "testDescription2", 1234L);
        Item test3 = new Item("test3", "testDescription3", 1235L);
        Item test4 = new Item("test4", "testDescription4", 1236L);
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        assertThat(tracker.findById(test2.getId()).getName(), is("test2"));
    }

    /**
     * Test findByName method.
     */
    @Test
    public void whenFindByNameThenReturnSameDesc() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("first", "testDescription1", 123L);
        Item test2 = new Item("second", "testDescription2", 1234L);
        Item test3 = new Item("third", "testDescription3", 1235L);
        Item test4 = new Item("fourth", "testDescription4", 1236L);
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        Item[] result = tracker.findByName("second");
        assertThat(result[0].getDesc(), is("testDescription2"));
        result = tracker.findByName("ir");
        assertThat(result[0].getDesc(), is("testDescription1"));
        assertThat(result[1].getDesc(), is("testDescription3"));
    }

}
