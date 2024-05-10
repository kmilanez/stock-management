package com.kmilanez.stockmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.xyz.models.Stock;
import org.junit.jupiter.api.Test;

class StockToMoneyConverterTest {
    
    @Test
    void itShouldHaveABalanceOf2() {
        var converter = new StockToMoneyConverter();
        var wallet = new Wallet();

        converter.convert(List.of(Stock.STOCK_B.name()), wallet);
        
        assertEquals(2, wallet.getBalance());
    }

    @Test
    void itShouldHaveABalanceOf4() {
        var converter = new StockToMoneyConverter();
        var wallet = new Wallet();

        converter.convert(List.of(Stock.STOCK_B.name(), Stock.STOCK_B.name()), wallet);
        
        assertEquals(4, wallet.getBalance());
    }

    /*
        This looks like a wrong test as Stock B has value of 2.0
        https://github.com/kmilanez/stock-management/blob/main/src/test/java/com/kmilanez/stockmanagement/StockToMoneyConverterTest.java#L32
        https://github.com/kmilanez/stock-management/blob/main/src/main/java/com/kmilanez/stockmanagement/StockValues.java#L12
     */
    //@Test
    void itShouldHaveABalanceOfOnePointOne() {
        var converter = new StockToMoneyConverter();
        var wallet = new Wallet();

        converter.convert(List.of(Stock.STOCK_B.name()), wallet);
        
        assertEquals(1.1, wallet.getBalance());
    }

}
