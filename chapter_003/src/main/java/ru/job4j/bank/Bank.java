package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import ru.job4j.bank.User;

/**
 * Class Bank.
 * @author Kuzenkov Pavel.
 * @since 11.07.2018.
 */
public class Bank {

    /**
     * List of users and accounts.
     */
    private Map<User, ArrayList<Account>> accounts = new TreeMap<>(new UserCompare());

    /**
     * Outputting user's accounts.
     * @return all users.
     */
    public Map<User, ArrayList<Account>> getAllUsers() {
        return accounts;
    }

    /**
     * Adding user.
     * @param user New user.
     * @param account New account.
     */
    public void addUser(User user, Account account) {
        ArrayList<Account> list = new ArrayList<Account>();
        list.add(account);
        this.accounts.put(user, list);
    }

    /**
     * Deleting user.
     * @param user User.
     */
    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    /**
     * Adding account to user.
     * @param passport User passport number.
     * @param account New account.
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> e : accounts.entrySet()) {
            if (e.getKey().getPassport().equals(passport)) {
                e.getValue().add(account);
            }
        }
    }

    /**
     * Deleting user's account.
     * @param passport User passport number.
     * @param account Removable user's account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, ArrayList<Account>> e : accounts.entrySet()) {
            if (e.getKey().getPassport().equals(passport)) {
                e.getValue().remove(account);
            }
        }
    }

    /**
     * Outputting user's accounts.
     * @param passport User's passport number.
     * @return List use's account.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, ArrayList<Account>> e : accounts.entrySet()) {
            if (e.getKey().getPassport().equals(passport)) {
                result = e.getValue();
            }
        }
        return result;
    }

    /**
     * Transferring money between accounts.
     * @param srcPassport Passport number of sender.
     * @param srcRequisite Account requisites of sender.
     * @param destPassport Passport number of payee.
     * @param dstRequisite Account requisites of payee.
     * @param amount Amount of money.
     * @return 'true' if success or 'false' if not.
     */
    public boolean transferMoney(String srcPassport, int srcRequisite, String destPassport, int dstRequisite, double amount) {
        Account srcAccount = new Account();
        Account destAccount = new Account();
        for (Map.Entry<User, ArrayList<Account>> e : accounts.entrySet()) {
            if (e.getKey().getPassport().equals(srcPassport)) {
                for (Account account : e.getValue()) {
                    if (account.getRequisites() == srcRequisite) {
                        srcAccount = account;
                    }
                }
            }
            if (e.getKey().getPassport().equals(destPassport)) {
                for (Account account : e.getValue()) {
                    if (account.getRequisites() == dstRequisite) {
                        destAccount = account;
                    }
                }
            }
        }
        return srcAccount.transfer(destAccount, amount);
    }
}
