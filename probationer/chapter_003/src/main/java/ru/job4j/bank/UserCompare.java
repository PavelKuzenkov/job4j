package ru.job4j.bank;

import java.util.Comparator;

/**
 * Class UserCompare.
 * @author Kuzenkov Pavel.
 * @since 11.07.2018.
 */
public class UserCompare implements Comparator<User> {

    /**
     * Overriding compare method.
     * @param left first User.
     * @param right second User.
     * @return
     */
    @Override
    public int compare(User left, User right) {
        return  left.getName().compareTo(right.getName());
    }
}
