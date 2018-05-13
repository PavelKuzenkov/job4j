package ru.job4j.condition;

/**
 * Class Condition решение задачи части 001 урок 3 3.4.
 *
 * @author Кузенков Павел
 * @since 12.05.2018
 */

public class Point {
    private int x;
    private int y;

    /**
     * Конструктор класса Point.
     * @param x координата x.
     * @param y координата y.
     */

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расчет расстояния между точками А и Вю
     * @param that точка А (объект типа Point).
     * @return расстояние между точками А и В.
     */

    public double distanceTo(Point that) {
        Point a = this;
        return Math.sqrt(Math.pow(that.x - a.x, 2) + Math.pow(that.y - a.y, 2));
    }

    /**
     * Метод Main. Описание точек А и В, вывод их координат и расстояния между ними в консоль
     * @param args
     */

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);
        System.out.println("Расстояние между точками А и В = " + a.distanceTo(b));
    }
}
