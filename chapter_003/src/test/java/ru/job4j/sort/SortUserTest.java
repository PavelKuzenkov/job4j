package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortUserTest решение задачи части 003 урок 3 1.
 *
 * @author Кузенков Павел.
 * @since 24.06.2018
 */
public class SortUserTest {

    /**
     * Test sort method.
     */
    @Test
    public void when5UsersThenSortedByAge() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Vasya", "10"));
        list.add(new User("Vova", "25"));
        list.add(new User("Lera", "5"));
        list.add(new User("Yura", "20"));
        list.add(new User("Petr", "15"));
        Set<User> result = sort.sort(list);
        int age = 0;
        for (User user : result) {
            assertThat(Integer.parseInt(user.getAge()), is(age += 5));
        }
    }

    /**
     * Test sortNameLength method.
     */
    @Test
    public void when4UsersThenSortedByNameAge() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Vladimir", "25"));
        list.add(new User("Lera", "5"));
        list.add(new User("Yuriy", "20"));
        list.add(new User("Arkadiy", "15"));
        List<User> result = sort.sortNameLength(list);
        assertThat(result.get(0).getName(), is("Lera"));
        assertThat(result.get(1).getName(), is("Yuriy"));
        assertThat(result.get(2).getName(), is("Arkadiy"));
        assertThat(result.get(3).getName(), is("Vladimir"));
    }

    /**
     * Test sortByAllFields method.
     */
    @Test
    public void when5UsersThenSortedByNameLength() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Vladimir", "25"));
        list.add(new User("Boris", "25"));
        list.add(new User("Arkadiy", "20"));
        list.add(new User("Arkadiy", "15"));
        list.add(new User("Arkadiy", "30"));
        list.add(new User("Boris", "15"));
        list.add(new User("Arkadiy", "15"));
        list.add(new User("Boris", "15"));
        list.add(new User("Vladimir", "10"));
        List<User> result = sort.sortByAllFields(list);
        assertThat(result.get(0).getName(), is("Arkadiy"));
        assertThat(result.get(0).getAge(), is("15"));
        assertThat(result.get(1).getName(), is("Arkadiy"));
        assertThat(result.get(1).getAge(), is("15"));
        assertThat(result.get(2).getName(), is("Arkadiy"));
        assertThat(result.get(2).getAge(), is("20"));
        assertThat(result.get(3).getName(), is("Arkadiy"));
        assertThat(result.get(3).getAge(), is("30"));
        assertThat(result.get(4).getName(), is("Boris"));
        assertThat(result.get(4).getAge(), is("15"));
        assertThat(result.get(5).getName(), is("Boris"));
        assertThat(result.get(5).getAge(), is("15"));
        assertThat(result.get(6).getName(), is("Boris"));
        assertThat(result.get(6).getAge(), is("25"));
        assertThat(result.get(7).getName(), is("Vladimir"));
        assertThat(result.get(7).getAge(), is("10"));
        assertThat(result.get(8).getName(), is("Vladimir"));
        assertThat(result.get(8).getAge(), is("25"));
    }


}
