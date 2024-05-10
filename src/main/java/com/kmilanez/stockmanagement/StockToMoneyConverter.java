package com.kmilanez.stockmanagement;

import java.util.List;

import static com.kmilanez.stockmanagement.StockValues.findStockValuesByStockName;

public class StockToMoneyConverter {
    
    public void convert(List<String> stocks, Wallet wallet) {

        for (String stock : stocks) {
            double stockValue = findStockValuesByStockName(stock);
            wallet.addMoney(stockValue);
        }
    }

}
