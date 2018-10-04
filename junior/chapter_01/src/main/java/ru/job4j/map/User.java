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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (children != user.children) return false;
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + children;
//        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
//        return result;
//    }
}
