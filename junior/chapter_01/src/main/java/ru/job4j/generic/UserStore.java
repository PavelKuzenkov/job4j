package ru.job4j.generic;
/**
 * Class UserStore.
 * @author Kuzenkov Pavel.
 * @since 01.09.2018.
 */
public class UserStore<T extends User> extends AbstractStore<User> {

    /**
     * Storage of data.
     */
    private SimpleArray<User> store = new SimpleArray<User>(10);

}
