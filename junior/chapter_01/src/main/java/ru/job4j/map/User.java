package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class User.
 * @author Kuzenkov Pavel.
 * @since 27.09.2018.
 */
public class User {

    /**
     * User name.
     */
    private String name;

    /**
     * Amount of children.
     */
    private int children;

    /**
     * Birthday.
     */
    private Calendar birthday;

    /**
     * Class constructor.
     * @param name User name.
     * @param amountOfChildren Amount of children.
     * @param day
     * @param month
     * @param year
     */
    public User(String name, int amountOfChildren, int day, int month, int year) {
        this.name = name;
        this.children = amountOfChildren;
        this.birthday = new GregorianCalendar(year, month, day);
    }
}
