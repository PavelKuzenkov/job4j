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
}
