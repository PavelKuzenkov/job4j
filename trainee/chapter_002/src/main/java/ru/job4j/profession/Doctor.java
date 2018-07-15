package ru.job4j.profession;

/**
 * Class Doctor решение задачи части 002 урок 2 1.
 *
 * @author Кузенков Павел.
 * @since 25.05.2018
 */
public class Doctor extends Profession {

    private String name;

    /**
     * Постановка диагноза.
     * @param patient пациент.
     * @return диагноз
     */
    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }
}
