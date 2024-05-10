package com.kmilanez.stockmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

class WalletTest {

    @Test
    void itShouldHaveABalanceOf1() {
        var wallet = new Wallet();
        wallet.addMoney(1.0);
        assertEquals(1.0, wallet.getBalance());
    }

    @Test
    void itShouldHaveABalanceOf5() {
        var wallet = new Wallet();
        wallet.addMoney(5.0);
        assertEquals(5.0, wallet.getBalance());
    }

    @Test
    void itShouldHaveABalanceOf6() {
        var wallet = new Wallet();
        wallet.addMoney(2.0);
        wallet.addMoney(2.0);
        wallet.addMoney(2.0);
        assertEquals(6.0, wallet.getBalance());
    }

    @Test
    void itShouldHaveABalanceOf6Point3() {
        var wallet = new Wallet();
        wallet.addMoney(2.1);
        wallet.addMoney(2.1);
        wallet.addMoney(2.1);
        // Found this online as test was failing because of :
        // Some floating point operations will compound the round-off error present in these floating point numbers.
        // Expected :6.3, Actual   :6.300000000000001
        assertEquals(6.3, wallet.getBalance());
    }

}
