package com.kmilanez.stockmanagement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Wallet {

    // Some floating point operations will compound the round-off error present in these floating point numbers.
    private BigDecimal balance;

    private BigDecimal createNumber(Double amount) {
        return new BigDecimal(amount).setScale(1, RoundingMode.DOWN);
    }

    public Wallet() {
        this.balance = createNumber(0.0);
    }

    public Wallet(Double initialBalance) {
        this.balance = createNumber(initialBalance);
    }

    public void addMoney(Double amount) {
        this.balance = this.balance.add(createNumber(amount));
    }

    public Double getBalance() {
        return this.balance.doubleValue();
    }
}
