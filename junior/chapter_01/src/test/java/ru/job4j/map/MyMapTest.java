package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyMapTest {

    @Test
    public void start() {
        Map<User, String> map = new HashMap<>();
        User user1 = new User("User1", 0, 20, 11, 1999);
        User user2 = new User("User1", 0, 20, 11, 1999);
        map.put(user1, "user1");
        map.put(user2, "user2");
        System.out.println(user1.equals(user2));
        System.out.println(map);
        Map<User, String> map2 = new HashMap<>();
        map2.put(user1, "user1");
        map2.put(user1, "user2");
        System.out.println(map2);
    }
}
