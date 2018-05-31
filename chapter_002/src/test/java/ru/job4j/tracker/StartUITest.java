package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 31.05.2018
 */
public class StartUITest {

    /**
     * Test createItem method.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * Test showAllItems method.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Test editItem method.
     */
    @Test
    public void whenEditeThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", "renamed", "new desc", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("renamed"));
    }

    /**
     * Test deleteItem method.
     */
    @Test
    public void whenDeleteItemThenReturnWithoutItem() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test1", "testDescription1");
        Item test2 = new Item("test2", "testDescription2");
        Item test3 = new Item("test3", "testDescription3");
        Item test4 = new Item("test4", "testDescription4");
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        Input input = new StubInput(new String[]{"3", test2.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.getAll();
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
        Item test = new Item("test name", "testDescription");
        tracker.add(test);
        Input input = new StubInput(new String[]{"4", test.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(test.getId()).getName(), is("test name"));
    }

    /**
     * Test findByName method.
     */
    @Test
    public void whenFindByNameThenReturnSameDesc() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("first", "testDescription1");
        Item test2 = new Item("second", "testDescription2");
        Item test3 = new Item("third", "testDescription3");
        Item test4 = new Item("fourth", "testDescription4");
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        Input input = new StubInput(new String[]{"5", "ir", "6"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findByName("ir");
        assertThat(result[0].getDesc(), is("testDescription1"));
        assertThat(result[1].getDesc(), is("testDescription3"));

    }
}
