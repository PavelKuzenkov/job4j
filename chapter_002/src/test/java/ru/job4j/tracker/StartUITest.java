package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;

    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Test createItem method.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "test name", "desc", "6", "y"});
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
        Input input = new StubInput(new String[]{"1", "6", "y"});
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
        Input input = new StubInput(new String[]{"2", "renamed", "new desc", item.getId(), "6", "y"});
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
        Input input = new StubInput(new String[]{"3", test2.getId(), "6", "y"});
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
        Input input = new StubInput(new String[]{"4", test.getId(), "6", "y"});
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
        Input input = new StubInput(new String[]{"5", "ir", "6", "y"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findByName("ir");
        assertThat(result[0].getDesc(), is("testDescription1"));
        assertThat(result[1].getDesc(), is("testDescription3"));

    }

    /**
     * Test getAll method.
     */
    @Test
    public void whenGetAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test1", "testDescription1");
        Item test2 = new Item("test2", "testDescription2");
        tracker.add(test1);
        tracker.add(test2);
        Input input = new StubInput(new String[]{"1", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0. Add new Item.\r\n")
                                .append("1. Show all items.\r\n")
                                .append("2. Edit item.\r\n")
                                .append("3. Delete item.\r\n")
                                .append("4. Find item by Id.\r\n")
                                .append("5. Find items by name.\r\n")
                                .append("6. Exit program.\r\n")
//                                .append("Select: \r\n")
//                                .append("Enter a menu item.\r\n")
                                .append("Заявка №1:\r\n")
                                .append("Имя: test1\r\n")
                                .append("Описание: testDescription1\r\n")
                                .append("ID: " + test1.getId() + "\r\n")
                                .append("\r\n")
                                .append("Заявка №2:\r\n")
                                .append("Имя: test2\r\n")
                                .append("Описание: testDescription2\r\n")
                                .append("ID: " + test2.getId() + "\r\n")
                                .append("\r\n")
                                .append("0. Add new Item.\r\n")
                                .append("1. Show all items.\r\n")
                                .append("2. Edit item.\r\n")
                                .append("3. Delete item.\r\n")
                                .append("4. Find item by Id.\r\n")
                                .append("5. Find items by name.\r\n")
                                .append("6. Exit program.")
//                                .append("Select: ")
//                                .append("Enter a menu item.")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
