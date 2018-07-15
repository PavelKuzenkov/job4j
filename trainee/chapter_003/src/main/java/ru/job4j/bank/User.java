package ru.job4j.bank;

/**
 * Class User.
 * @author Kuzenkov Pavel.
 * @since 11.07.2018.
 */
public class User {

    /**
     * User name.
     */
    private final String name;

    /**
     * User passport number.
     */
    private final String passport;

    /**
     * Class constructor.
     * @param name user name.
     * @param passport user passport number.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
    }

    /**
     * Overriding equals method.
     * @param o another User.
     * @return 'true' if equals or 'false' if not equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!name.equals(user.name)) {
            return false;
        }
        return passport.equals(user.passport);
    }

    /**
     * Overriding hashCode method.
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result
                + passport.hashCode();
        return result;
    }

    /**
     * Overriding toString method.
     * @return
     */
    @Override
    public String toString() {
        return "Name: "
                + this.passport
                .concat(System.lineSeparator())
                + "Passport: "
                + this.passport
                .concat(System.lineSeparator());
    }
}
