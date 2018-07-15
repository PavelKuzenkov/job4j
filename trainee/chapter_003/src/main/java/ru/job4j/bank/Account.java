package ru.job4j.bank;

import java.util.Random;

/**
 * Class Account.
 * @author Kuzenkov Pavel.
 * @since 11.07.2018.
 */
public class Account {

    /**
     * Amount of money.
     */
    private double value;

    /**
     * Account requisites.
     */
    private int requisites;

    private static final Random RN = new Random();

    /**
     * Class constructor.
     */
    public Account() {
        this.value = 0.0;
        this.requisites = (int) System.currentTimeMillis() + RN.nextInt();
    }

    public double getValue() {
        return value;
    }

    public int getRequisites() {
        return requisites;
    }

    /**
     * Adding money to this account.
     * @param value Amount of money.
     */
    public void addValue(double value) {
        this.value += value;
    }

    /**
     * Deducting money.
     * @param value Amount of money.
     * @return 'true' if success or 'false' if not.
     */
    public boolean deductValue(double value) {
        boolean result = false;
        if (this.value >= value) {
            this.value -= value;
            result = true;
        }
        return result;
    }

    /**
     * Transferring money between accounts.
     * @param account destination account.
     * @param value Amount of money.
     * @return 'true' if success or 'false' if not.
     */
    public boolean transfer(Account account, double value) {
        boolean result = false;
        if (this.value >= value) {
            this.value -= value;
            account.addValue(value);
            result = true;
        }
        return result;
    }

    /**
     * Overriding equals method.
     * @param o another Account.
     * @return 'true' if equals or 'false' if not equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (value != account.value) {
            return false;
        }
        return requisites == account.requisites;
    }

    /**
     * Overriding hashCode method.
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result
                + requisites;
        return result;
    }

    /**
     * Overriding toString method.
     * @return
     */
    @Override
    public String toString() {
        return "Value: "
                + Double.toString(this.value)
                .concat(System.lineSeparator())
                + "Requisites: "
                + Integer.toString(this.requisites)
                .concat(System.lineSeparator());
    }
}
