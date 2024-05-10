package com.kmilanez.stockmanagement;

import com.xyz.models.Stock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockValuesTest {
    
    @Test
    void itShouldReturnStockValueStockIfItExists() {
        Double stockValue = StockValues.findStockValuesByStockName(Stock.STOCK_A.name());
        assertEquals(1.1, stockValue);
    }


    @Test
    void itShouldReturnZeroIfStockDoesNotExist() {
        Double stockValue = StockValues.findStockValuesByStockName("Stock_K");
        assertEquals(0.0, stockValue);
    }

    @Test
    void itShouldAllowANewStockToBeAdded() {
        StockValues.addStock("Stock_K", 5.0);
        Double stockValue = StockValues.findStockValuesByStockName("Stock_K");
        assertEquals(5.0, stockValue);
    }

    /*
        Approach is able to insert 10mil in 20 seconds but failing for 10 seconds
        Even after creating an initial size of 20mil, its not under 10 sec
        But it is able to process 6mil under 10 sec
        Possible reasons :
            - lots of object conversion, double -> BigDecimal -> Double
            - String formatting
    */
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    void shouldInsertTenMillionNewStocksIn10Seconds() throws InterruptedException {
        for (int i = 0; i < 10000000; i++) {
            StockValues.addStock("Stock_%s".formatted(i), Double.valueOf(i));
        }
    }

    /*
        The solution I think for this would be async processing
        Additionally distributed store would be used to parallelize the addition of stock
    */
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
    void shouldInsertTenMillionNewStocksIn1Second() throws InterruptedException {
        for (int i = 0; i < 10000000; i++) {
            StockValues.addStock("Stock_%s".formatted(i), Double.valueOf(i));
        }
    }


}
