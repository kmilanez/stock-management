package com.kmilanez.stockmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

class StockValuesTest {
    
    @Test
    void itShouldReturnStockValueStockIfItExists() {
        Double stockValue = StockValues.findStockValuesByStockName(StockNames.STOCK_A);
        assertEquals(1.1, stockValue);
    }


    @Test
    void itShouldReturnZeroIfStockDoesNotExist() {
        Double stockValue = StockValues.findStockValuesByStockName("Stock_K");
        assertEquals(0.0, stockValue);
    }

    @Test
    void itShouldAllowANewStockToBeAdded() {
        StockValues.addStock(new ValuePair<String,Double>("Stock_K", 5.0));
        Double stockValue = StockValues.findStockValuesByStockName("Stock_K");
        assertEquals(5.0, stockValue);
    }
}
