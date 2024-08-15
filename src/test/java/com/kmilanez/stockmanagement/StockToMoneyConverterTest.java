package com.kmilanez.stockmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StockToMoneyConverterTest {
    
    @Test
    void itShouldHaveABalanceOf2() {
        var converter = new StockToMoneyConverter();
        var wallet = new Wallet();

        converter.convert(List.of(StockNames.STOCK_B), wallet);
        
        assertEquals(2, wallet.getBalance());
    }

    @Test
    void itShouldHaveABalanceOf4() {
        var converter = new StockToMoneyConverter();
        var wallet = new Wallet();

        converter.convert(List.of(StockNames.STOCK_B, StockNames.STOCK_B), wallet);
        
        assertEquals(4, wallet.getBalance());
    }

    @Test
    void itShouldHaveABalanceOfTwo() {
        var converter = new StockToMoneyConverter();
        var wallet = new Wallet();

        converter.convert(List.of(StockNames.STOCK_B), wallet);
        
        assertEquals(2.0, wallet.getBalance());
    }

}
