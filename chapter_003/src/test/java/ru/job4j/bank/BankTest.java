package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.bank.User;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Class AccountTest.
 * @autor Kuzenkov Pavel.
 * @since 11.07.2018
 */
public class BankTest {

    /**
     * Test addUser method.
     */
    @Test
    public void whenAddingUserThenAdd() {
        User user1 = new User("Mike", "123456");
        Account account1 = new Account();
        account1.addValue(10);
        Bank bank = new Bank();
        bank.addUser(user1, account1);
        boolean result = bank.getAllUsers().containsKey(user1);
        double resultValue = bank.getAllUsers().get(user1).get(0).getValue();
        double valueExpected = 10;
        assertThat(result, is(true));
        assertThat(resultValue, is(valueExpected));
    }

    /**
     * Test deleteUser method.
     */
    @Test
    public void whenDeleteUserThenNotHasUser() {
        User user1 = new User("Mike", "123456");
        Account account1 = new Account();
        account1.addValue(10);
        User user2 = new User("Paul", "654321");
        Account account2 = new Account();
        account2.addValue(20);
        Bank bank = new Bank();
        bank.addUser(user1, account1);
        bank.addUser(user2, account2);
        bank.deleteUser(user1);
        boolean result1 = bank.getAllUsers().containsKey(user1);
        boolean result2 = bank.getAllUsers().containsKey(user2);
        double resultValue = bank.getAllUsers().get(user2).get(0).getValue();
        double valueExpected = 20;
        assertThat(result1, is(false));
        assertThat(result2, is(true));
        assertThat(resultValue, is(valueExpected));
    }

    /**
     * Test addAccountToUser method.
     */
    @Test
    public void whenAddAccountThenUserHasNewAccount() {
        User user1 = new User("Mike", "123456");
        Account account1 = new Account();
        account1.addValue(10);
        Account account2 = new Account();
        account2.addValue(20);
        Bank bank = new Bank();
        bank.addUser(user1, account1);
        bank.addAccountToUser("123456", account2);
        double resultValue1 = bank.getAllUsers().get(user1).get(0).getValue();
        double resultValue2 = bank.getAllUsers().get(user1).get(1).getValue();
        double valueExpected1 = 10;
        double valueExpected2 = 20;
        assertThat(resultValue1, is(valueExpected1));
        assertThat(resultValue2, is(valueExpected2));
    }

    /**
     * Test deleteAccountFromUser method.
     */
    @Test
    public void whenDeleteAccountThenUserHasNotThisAccount() {
        User user1 = new User("Mike", "123456");
        Account account1 = new Account();
        account1.addValue(10);
        Account account2 = new Account();
        account2.addValue(20);
        Bank bank = new Bank();
        bank.addUser(user1, account1);
        bank.addAccountToUser("123456", account2);
        double resultValue1 = bank.getAllUsers().get(user1).get(0).getValue();
        double resultValue2 = bank.getAllUsers().get(user1).get(1).getValue();
        double valueExpected1 = 10;
        double valueExpected2 = 20;
        assertThat(resultValue1, is(valueExpected1));
        assertThat(resultValue2, is(valueExpected2));
        bank.deleteAccountFromUser("123456", account2);
        resultValue1 = bank.getAllUsers().get(user1).get(0).getValue();
        assertThat(resultValue1, is(valueExpected1));
        boolean deleteResalt = bank.getAllUsers().get(user1).contains(account2);
        assertThat(deleteResalt, is(false));
    }

    /**
     * Test getUserAccounts method.
     */
    @Test
    public void whenGetUserAccountsThenUserAccounts() {
        User user1 = new User("Mike", "123456");
        Account account1 = new Account();
        account1.addValue(10);
        Account account2 = new Account();
        account2.addValue(20);
        Bank bank = new Bank();
        bank.addUser(user1, account1);
        bank.addAccountToUser("123456", account2);
        List<Account> list = bank.getUserAccounts("123456");
        boolean result1 = list.contains(account1);
        boolean result2 = list.contains(account2);
        assertThat(result1, is(true));
        assertThat(result1, is(true));
    }

    /**
     * Test transferMoney method.
     */
    @Test
    public void whenTransferThenTransferring() {
        User user1 = new User("Mike", "123456");
        Account account1 = new Account();
        account1.addValue(10);
        User user2 = new User("Paul", "654321");
        Account account2 = new Account();
        account2.addValue(20);
        Bank bank = new Bank();
        bank.addUser(user1, account1);
        bank.addUser(user2, account2);
        int srcRequisite = account1.getRequisites();
        int destRequisite = account2.getRequisites();
        boolean transfer = bank.transferMoney("123456", srcRequisite, "654321", destRequisite, 5);
        double transferResult1 = account1.getValue();
        double transferResult2 = account2.getValue();
        double transferExpected1 = 5.00;
        double transferExpected2 = 25.00;
        assertThat(transfer, is(true));
        assertThat(transferResult1, is(transferExpected1));
        assertThat(transferResult2, is(transferExpected2));
    }
}
