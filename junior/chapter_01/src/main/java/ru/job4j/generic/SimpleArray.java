package ru.job4j.generic;

/**
 * Class SimpleArray.
 * @author Kuzenkov Pavel.
 * @since 15.08.2018.
 */
public class SimpleArray<T> {

    /**
     * Source array.
     */
    private Object[] objects;

    /**
     * Position in source array.
     */
    private int index = 0;

    /**
     * class constructor.
     * @param size size of source array.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Adding a new object to array.
     * @param value new object.
     */
    public void add(T value) {
        if (this.objects.length == this.index) {
            throw new ArrayIndexOutOfBoundsException("The array is full!");
        }
        this.objects[index++] = value;
    }


    /**
     * Set an object to array.
     * @param position position.
     * @param value new object.
     */
    public void set(int position, T value) {
        this.objects[position] = value;
    }

    /**
     * Delete an object in certain position.
     * @param position position.
     */
    public void delete(int position) {
        System.arraycopy(this.objects, position + 1, this.objects, position, this.objects.length - position - 1);
        this.objects[this.objects.length - 1] = null;
    }

    /**
     * Getting the object in certain position.
     * @param position position.
     * @return object.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }
}
