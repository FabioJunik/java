package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manage streaming service.
 *
 * @author POO
 */
public class StreamingService {

    private List<Account> activeAccounts;

    /**
     * Constructor of class StreamingService.
     */
    public StreamingService() {
        this.activeAccounts = new ArrayList<>();
    }

    /**
     * Get the list of accounts.
     *
     * @return This streaming service active accounts.
     */
    public List<Account> getActiveAccounts() {
        return activeAccounts;
    }

    /**
     * Add an account.
     *
     * @param account to add.
     */
    public void addAccount(Account account) {
        activeAccounts.add(account);
    }

    /**
     * Remove an account.
     *
     * @param account to remove.
     */
    public void removeAccount(Account account) {
        activeAccounts.remove(account);
    }

    /**
     * Remove all accounts that didn't pay. Implementation using an iterator.
     */
    public void removeUnpaidAccounts() {
        Iterator<Account> iterator = activeAccounts.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isPaid()) {
                iterator.remove();
            }
        }
    }

    /**
     * Clear all payments. Implementation using functional
     * programming.
     */
    public void setAllAccountsAsUnpaid() {
        activeAccounts.stream().forEach(account -> account.setPaid(false));
    }

    /**
     * Remove all accounts that didn't pay. Implementation using removeIf method.
     */
    public void removeUnpaidAccountsRemoveIf() {
        activeAccounts.removeIf(account -> !account.isPaid());
    }

    /**
     * Get the list of accounts that didn't pay. Implementation using functional
     * programming.
     *
     * @return A list with all accounts that didn't pay.
     */
    public List<Account> getListOfUnpaidAccounts() {
        List<Account> unpaidAccounts = new ArrayList<>();
        activeAccounts.stream().filter(account -> !account.isPaid()).forEach(unpaidAccounts::add);
        return unpaidAccounts;
    }

    /**
     * Count the amount of accounts that didn't pay. Implementation using
     * functional programming.
     *
     * @return The amount of accounts that didn't pay.
     */
    public long countUnpaidAccounts() {
        return activeAccounts.stream().filter(account -> !account.isPaid()).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contas do serviço de streaming:\n\n");
        sb.append("Nome                Pago\n");
        for (Account account : activeAccounts) {
            sb.append(account.getName()).append(" ").append(account.isPaid()).append("\n");
        }
        return sb.toString();
    }
}
