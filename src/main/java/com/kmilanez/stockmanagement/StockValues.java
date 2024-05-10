package com.kmilanez.stockmanagement;

import com.xyz.models.Stock;

import java.util.HashMap;
import java.util.Map;

public class StockValues {
    
    private static final Map<String, Double> STOCKS_STORE = new HashMap<>(20000000);

    static {
        for (Stock stock : Stock.values()) {
            STOCKS_STORE.put(stock.name(), stock.value());
        }
    }

    public static void addStock(String name, double value) {
        STOCKS_STORE.put(name, value);
    }

    public static Double findStockValuesByStockName(String stockName) {
        // else part of "StockToMoneyConverter" which returned 3.0 when stock does not matches list of stocks present is moved here to pass 3.0 as default
        // but since test was failing so I am assuming this 3.0 was unreachable : https://github.com/kmilanez/stock-management/blob/main/src/test/java/com/kmilanez/stockmanagement/StockValuesTest.java#L21
        return STOCKS_STORE.getOrDefault(stockName, 0.0);
    }

}