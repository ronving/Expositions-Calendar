package com.ronving.model.builders;

import com.ronving.model.Account;

public class AccountBuilder {
    private Account account = new Account();
    public AccountBuilder setId(int id) {
        account.setId(id);
        return this;
    }


    public AccountBuilder setLogin(String login) {
        account.setLogin(login);
        return this;
    }

    public AccountBuilder setPassword(String password) {
        account.setPassword(password);
        return this;
    }

    public AccountBuilder setRole() {
        account.setRole();
        return this;
    }

    public Account build() {
        return account;
    }
}
