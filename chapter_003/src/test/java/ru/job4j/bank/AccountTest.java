package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.Account;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class AccountTest.
 * @autor Kuzenkov Pavel.
 * @since 11.07.2018
 */
public class AccountTest {

    /**
     * Test equals method.
     * When not equals.
     */
    @Test
    public void whenUsersNotEqualsThenNotEquals() {
        Account account1 = new Account();
        Account account2 = new Account();
        boolean result = account1.equals(account2);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test addValue, deductValue and getValue methods.
     */
    @Test
    public void whenAdd101ThenHas101() {
        Account account = new Account();
        account.addValue(101.1);
        double addResult = account.getValue();
        double addExpected = 101.1;
        assertThat(addResult, is(addExpected));
        boolean deduct = account.deductValue(100.1);
        double deductResalt = account.getValue();
        double deductExpected = 1.0;
        assertThat(deduct, is(true));
        assertThat(deductResalt, is(deductExpected));
    }

    /**
     * Test transfer method.
     */
    @Test
    public void whenTransferThenTransferring() {
        Account account1 = new Account();
        Account account2 = new Account();
        account1.addValue(100.00);
        boolean transfer = account1.transfer(account2, 65.00);
        double transferResult1 = account1.getValue();
        double transferResult2 = account2.getValue();
        double transferExpected1 = 35.00;
        double transferExpected2 = 65.00;
        assertThat(transfer, is(true));
        assertThat(transferResult1, is(transferExpected1));
        assertThat(transferResult2, is(transferExpected2));
    }

}
