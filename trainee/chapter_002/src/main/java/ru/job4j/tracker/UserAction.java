package ru.job4j.tracker;

public interface UserAction {

    int key();

    void exicute(Input input, Tracker tracker);

    String info();

}
