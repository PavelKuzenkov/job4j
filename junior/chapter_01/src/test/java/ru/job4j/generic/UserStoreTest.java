package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserStoreTest {

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        UserStore<User> simple = new UserStore<User>();
        User user = new User("Test");
        simple.add(user);
        User result = simple.findById("Test");
        assertThat(result, is(user));
    }

    @Test
    public void whenReplaceUserThenReplaced() {
        UserStore<User> simple = new UserStore<User>();
        User user1 = new User("Test1");
        User user2 = new User("Test2");
        simple.add(user1);
        int result1 = simple.findPositionById("Test1");
        assertThat(result1, is(0));
        simple.replace("Test1", user2);
        int result2 = simple.findPositionById("Test1");
        assertThat(result2, is(-1));
        User result3 = simple.findById("Test2");
        assertThat(result3, is(user2));
    }

    @Test
    public void whenDeleteUserThenDeleted() {
        UserStore<User> simple = new UserStore<User>();
        User user1 = new User("Test1");
        User user2 = new User("Test2");
        simple.add(user1);
        simple.add(user2);
        simple.delete("Test1");
        int result1 = simple.findPositionById("Test1");
        assertThat(result1, is(-1));
        int result2 = simple.findPositionById("Test2");
        assertThat(result2, is(0));
    }

}