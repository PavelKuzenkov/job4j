package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Внешний внутренний класс.
 */
class EditItem extends BaseAction {

    /**
     * Конструктор класса.
     * @param key номер действия.
     * @param name описание действия.
     */
    public EditItem(int key, String name) {
        super(key, name);
    }

    /**
     * Реализация редактирования заявки.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public void exicute(Input input, Tracker tracker) {
        System.out.println("---------- Замена заявки -------------");
        String name = input.ask("Введите имя новой заявки: ");
        String desc = input.ask("Введите описание новой заявки: ");
        Item item = new Item(name, desc);
        String id = input.ask("Введите ID заявки которую нужно заменить: ");
        tracker.replace(id, item);
        System.out.print("------------ Заявка заменена ------------");
        System.out.println();
    }
}

/**
 * Внешний класс.
 */
public class MenuTracker {

    /**
     * Получение данных от пользователя.
     */
    private Input input;

    /**
     * Хранилище заявок.
     */
    private Tracker tracker;

    /**
     * Меню.
     */
    private ArrayList<UserAction> actions;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполнение массива дейтвиями.
     * @param ui
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item."));
        this.actions.add(new ShowItems(1, "Show all items."));
        this.actions.add(new EditItem(2, "Edit item."));
        this.actions.add(new DeleteItems(3, "Delete item."));
        this.actions.add(new FindByIdItem(4, "Find item by Id."));
        this.actions.add(new FindByNameItem(5, "Find items by name."));
        this.actions.add(new Exit(ui));
        int[] range = new int[this.actions.size()];
        for (int index = 0; index != range.length; index++) {
            range[index] = index;
        }
        ui.setRange(range);
    }

    /**
     * Действие введенное пользователем.
     * @param key номер действия.
     */
    public void select(int key) {
        this.actions.get(key).exicute(this.input, this.tracker);
    }

    /**
     * Вывод меню в консоль.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний класс.
     */
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * Реализация добавления заявки.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public void exicute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
            System.out.println();
        }

    }

    /**
     * Внутренний класс.
     */
    private static class ShowItems extends BaseAction {

        /**
         * Конструктор класса.
         * @param key номер действия.
         * @param name описание действия.
         */
        public ShowItems(int key, String name) {
            super(key, name);
        }

        /**
         * Реализация вывода всех заявок на экран.
         * @param input
         * @param tracker
         */
        public void exicute(Input input, Tracker tracker) {
            ArrayList<Item> all = tracker.getAll();
            for (int index = 0; index != all.size(); index++) {
                System.out.println("Заявка №" + (index + 1) + ":");
                System.out.println("Имя: " + all.get(index).getName());
                System.out.println("Описание: " + all.get(index).getDesc());
                System.out.println("ID: " + all.get(index).getId());
                System.out.println();
            }
        }
    }

    /**
     * Внутренний класс.
     */
    private static class DeleteItems extends BaseAction {

        /**
         * Конструктор класса.
         * @param key номер действия.
         * @param name описание действия.
         */
        public DeleteItems(int key, String name) {
            super(key, name);
        }

        /**
         * Реализация удаления заявки.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public void exicute(Input input, Tracker tracker) {
            System.out.println("---------- Удаление заявки -------------");
            String id = input.ask("Введите ID заявки которую нужно удалить: ");
            tracker.delete(id);
            System.out.println("---------- Заявка удалена -------------");
            System.out.println();
        }
    }

    /**
     * Внутренний класс.
     */
    private class FindByIdItem extends BaseAction {

        /**
         * Конструктор класса.
         * @param key номер действия.
         * @param name описание действия.
         */
        public FindByIdItem(int key, String name) {
            super(key, name);
        }

        /**
         * Реализация поиска заявки по ID.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public void exicute(Input input, Tracker tracker) {
            System.out.println("---------- Поиск заявки по ID -------------");
            String id = input.ask("Введите ID заявки: ");
            Item find = tracker.findById(id);
            if (find != null) {
                System.out.println("Заявка найдена.");
                System.out.println("Имя: " + find.getName());
                System.out.println("Описание: " + find.getDesc());
                System.out.println();
            } else {
                System.out.println("Заявке не найдена.");
                System.out.println();
            }
        }
    }

    /**
     * Внутренний класс.
     */
    private class FindByNameItem extends BaseAction {

        /**
         * Конструктор класса.
         * @param key номер действия.
         * @param name описание действия.
         */
        public FindByNameItem(int key, String name) {
            super(key, name);
        }

        /**
         * Реализация поиска заявки по имени.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public void exicute(Input input, Tracker tracker) {
            System.out.println("---------- Поиск заявки по имени -------------");
            String name = input.ask("Введите имя заявки: ");
            ArrayList<Item> find = tracker.findByName(name);
            if (find != null) {
                for (Item item: find) {
                    System.out.println("Заявка найдена.");
                    System.out.println("Имя: " + item.getName());
                    System.out.println("Описание: " + item.getDesc());
                    System.out.println("ID: " + item.getId());
                    System.out.println();
                }

            } else {
                System.out.println("Заявке не найдена.");
                System.out.println();
            }
        }
    }

    /**
     * Внутренний класс.
     */
    private class Exit implements UserAction {

        private StartUI ui;

        Exit(StartUI ui) {
            this.ui = ui;
        }

        /**
         * Действие пользователя.
         * @return номер действия в меню.
         */
        public int key() {
            return 6;
        }

        /**
         * Реализация выхода из программы.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public void exicute(Input input, Tracker tracker) {
            boolean stop = false;
            while (!stop) {
                String key = input.ask("Exit? y/n: ");
                switch (key) {
                    case "y" :
                        this.ui.exit();
                        stop = true;
                        break;
                    case "n" :
                        stop = true;
                        break;
                    default:
                        break;
                }
            }
        }

        /**
         * Вывод в консоль описания действия.
         * @return описание действия.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Exit program.");
        }

    }
}
