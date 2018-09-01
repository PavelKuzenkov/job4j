package ru.job4j.generic;

/**
 * Class RoleStore.
 * @author Kuzenkov Pavel.
 * @since 01.09.2018.
 */
public class RoleStore<T extends Role> extends AbstractStore<Role> {

    /**
     * Storage of data.
     */
    private SimpleArray<Role> store = new SimpleArray<Role>(10);

}
