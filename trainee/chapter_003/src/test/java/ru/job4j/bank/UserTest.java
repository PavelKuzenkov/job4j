package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.User;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class UserTest.
 * @autor Kuzenkov Pavel.
 * @since 11.07.2018
 */
public class UserTest {

    /**
     * Test equals method.
     * When not equals.
     */
    @Test
    public void whenUsersNotEqualsThenNotEquals() {
        User user1 = new User("Mike", "123456");
        User user2 = new User("Pit", "654321");
        boolean result = user1.equals(user2);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test equals method.
     * When equals.
     */
    @Test
    public void whenUsersEqualsThenEquals() {
        User user1 = new User("Mike", "123456");
        User user2 = new User("Mike", "123456");
        boolean result = user1.equals(user2);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}
