package ru.job4j.tracker;

/**
 * Внешний внутренний класс.
 */
class EditItem implements UserAction {

    /**
     * Действие пользователя.
     * @return номер действия в меню.
     */
    public int key() {
        return 2;
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

    /**
     * Вывод в консоль описания действия.
     * @return описание действия.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item.");
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
    private UserAction[] actions = new UserAction[7];

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
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItems();
        this.actions[4] = new FindByIdItem();
        this.actions[5] = new FindByNameItem();
        this.actions[6] = new Exit(ui);
        ui.setRange(this.actions.length);
    }

    /**
     * Действие введенное пользователем.
     * @param key номер действия.
     */
    public void select(int key) {
        this.actions[key].exicute(this.input, this.tracker);
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
    private class AddItem implements UserAction {

        /**
         * Действие пользователя.
         * @return номер действия в меню.
         */
        public int key() {
            return 0;
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

        /**
         * Вывод в консоль описания действия.
         * @return описание действия.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item.");
        }

    }

    /**
     * Внутренний класс.
     */
    private static class ShowItems implements UserAction {

        /**
         * Действие пользователя.
         * @return номер действия в меню.
         */
        public int key() {
            return 1;
        }

        /**
         * Реализация вывода всех заявок на экран.
         * @param input
         * @param tracker
         */
        public void exicute(Input input, Tracker tracker) {
            Item[] all = tracker.getAll();
            for (int index = 0; index != all.length; index++) {
                System.out.println("Заявка №" + (index + 1) + ":");
                System.out.println("Имя: " + all[index].getName());
                System.out.println("Описание: " + all[index].getDesc());
                System.out.println("ID: " + all[index].getId());
                System.out.println();
            }
        }

        /**
         * Вывод в консоль описания действия.
         * @return описание действия.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }

    }

    /**
     * Внутренний класс.
     */
    private static class DeleteItems implements UserAction {

        /**
         * Действие пользователя.
         * @return номер действия в меню.
         */
        public int key() {
            return 3;
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

        /**
         * Вывод в консоль описания действия.
         * @return описание действия.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }

    }

    /**
     * Внутренний класс.
     */
    private class FindByIdItem implements UserAction {

        /**
         * Действие пользователя.
         * @return номер действия в меню.
         */
        public int key() {
            return 4;
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

        /**
         * Вывод в консоль описания действия.
         * @return описание действия.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }

    }

    /**
     * Внутренний класс.
     */
    private class FindByNameItem implements UserAction {

        /**
         * Действие пользователя.
         * @return номер действия в меню.
         */
        public int key() {
            return 5;
        }

        /**
         * Реализация поиска заявки по имени.
         * @param input ввод данных.
         * @param tracker хранилище заявок.
         */
        public void exicute(Input input, Tracker tracker) {
            System.out.println("---------- Поиск заявки по имени -------------");
            String name = input.ask("Введите имя заявки: ");
            Item[] find = tracker.findByName(name);
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

        /**
         * Вывод в консоль описания действия.
         * @return описание действия.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name.");
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
