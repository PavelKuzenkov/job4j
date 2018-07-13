package ru.job4j.generics;


import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Kuzenkov Pavel
 * @since 21.06.2018
 */
public class UserConvertTest {

    /**
     * Test toArray method.
     */
    @Test
    public void when4UsersThen4UsersWithId() {
        List<User> list = new ArrayList<>();
        list.add(new User("541", "Ivan", "Uryupinsk"));
        list.add(new User("623", "Vasiliy", "Moskov"));
        list.add(new User("964", "Petr", "Tver"));
        list.add(new User("975", "Boris", "Tula"));
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = userConvert.process(list);
        User user1 = result.get(541);
        User user2 = result.get(623);
        User user3 = result.get(964);
        User user4 = result.get(975);
        assertThat(user1.getCity(), is("Uryupinsk"));
        assertThat(user2.getName(), is("Vasiliy"));
        assertThat(user3.getId(), is("964"));
        assertThat(user4.getCity(), is("Tula"));

    }
}
