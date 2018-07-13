package ru.job4j.search;

import java.util.LinkedList;

/**
 * Class PriorityQueue решение задачи части 003 урок 1 2.
 *
 * @author Кузенков Павел.
 * @since 18.06.2018
 */
public class PriorityQueue {

    /**
     * Список задач.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет элемент в нужную позицию.
     *
     * @param task задача
     */
    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            this.tasks.addFirst(task);
        } else {
            for (int index = 0; index != this.tasks.size(); index++) {
                if (task.getPriority() <= this.tasks.get(index).getPriority()) {
                    this.tasks.add(index, task);
                    break;
                }
                if (index == this.tasks.size() - 1) {
                    this.tasks.addLast(task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
