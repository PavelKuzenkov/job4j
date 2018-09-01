package ru.job4j.generic;

/**
 * Abstract class AbstractStore.
 * @author Kuzenkov Pavel.
 * @since 30.08.2018.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Storage of data.
     */
    private SimpleArray<T> store = new SimpleArray<T>(10);

    /**
     * Adding user or role to store.
     * @param model
     */
    @Override
    public void add(T model) {
        this.store.add(model);
    }

    /**
     * Replacing user or role in store.
     * @param id Replaceable ID.
     * @param model New user or role.
     * @return "true" if replace, or "false" if not.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int position = this.findPositionById(id);
        if (position != -1) {
            result = true;
            this.store.set(position, model);
        }
        return result;
    }

    /**
     * Deleting user or role.
     * @param id Removable ID.
     * @return "true" if delete, or "false" if not.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int position = this.findPositionById(id);
        if (position != -1) {
            result = true;
            this.store.delete(position);
        }
        return result;
    }

    /**
     * Find user or role by ID.
     * @param id ID.
     * @return user or role. If object is not exist, then null.
     */
    @Override
    public T findById(String id) {
        T result = null;
        int position = this.findPositionById(id);
        if (position != -1) {
            result = this.store.get(position);
        }
        return result;
    }

    /**
     * Getting the position of object.
     * @param id object id.
     * @return number of position. If object is not exist, then -1.
     */
    public int findPositionById(String id) {
        int result = -1;
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i) != null && store.get(i).getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
