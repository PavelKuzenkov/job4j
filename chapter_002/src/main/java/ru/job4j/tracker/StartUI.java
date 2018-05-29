package ru.job4j.tracker;

/**
 *  Class StartUI решение задачи части 002 урок 4 1.
 *
 * @author Кузенков Павел
 * @version $Id$
 * @since 28.05.2018
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FINDID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask();
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showAllItems();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FINDID:
                    this.findById();
                    break;
                case FINDNAME:
                    this.findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("Enter a menu item.");
                    break;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        System.out.print("Введите имя заявки: ");
        String name = this.input.ask();
        System.out.print("Введите описание заявки: ");
        String desc = this.input.ask();
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        System.out.println();
    }

    /**
     * Метод реализует вывод списка всех заявок.
     */
    private void showAllItems() {
        Item[] all = this.tracker.getAll();
        for (int index = 0; index != all.length; index++) {
            System.out.println("Заявка №" + (index + 1) + ":");
            System.out.println("Имя: " + all[index].getName());
            System.out.println("Описание: " + all[index].getDesc());
            System.out.println("ID: " + all[index].getId());
            System.out.println();
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("---------- Замена заявки -------------");
        System.out.print("Введите имя новой заявки: ");
        String name = this.input.ask();
        System.out.print("Введите описание новой заявки: ");
        String desc = this.input.ask();
        Item item = new Item(name, desc);
        System.out.print("Введите ID заявки которую нужно заменить: ");
        String id = this.input.ask();
        this.tracker.replace(id, item);
        System.out.print("------------ Заявка заменена ------------");
        System.out.println();
    }

    /**
     * Удаление заявки.
     */
    private void deleteItem() {
        System.out.println("---------- Удаление заявки -------------");
        System.out.print("Введите ID заявки которую нужно удалить: ");
        String id = this.input.ask();
        this.tracker.delete(id);
        System.out.println("---------- Заявка удалена -------------");
        System.out.println();
    }

    /**
     * Поиск по ключу.
     */
    private void findById() {
        System.out.println("---------- Поиск заявки по ID -------------");
        System.out.print("Введите ID заявки: ");
        String id = this.input.ask();
        Item find = this.tracker.findById(id);
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
     * Поиск по имени.
     */
    private void findByName() {
        System.out.println("---------- Поиск заявки по ID -------------");
        System.out.print("Введите ID заявки: ");
        String name = this.input.ask();
        Item find = this.tracker.findById(name);
        if (find != null) {
            System.out.println("Заявка найдена.");
            System.out.println("Имя: " + find.getName());
            System.out.println("Описание: " + find.getDesc());
            System.out.println("ID: " + find.getId());
            System.out.println();
        } else {
            System.out.println("Заявке не найдена.");
            System.out.println();
        }
    }

    /**
     * Вывод главного меню.
     */
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select: ");
        System.out.println();
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}