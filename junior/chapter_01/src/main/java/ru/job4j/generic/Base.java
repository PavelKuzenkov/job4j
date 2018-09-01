package ru.job4j.generic;

/**
 * Abstract class Base.
 * @author Kuzenkov Pavel.
 * @since 01.09.2018.
 */
public abstract class Base {

    /**
     * ID.
     */
    private final String id;

    /**
     * Class constructor.
     * @param id
     */
    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Overriding equals method.
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id.equals(base.id);
    }

    /**
     * Overriding hashCode method.
     * @return
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}