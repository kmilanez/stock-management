package com.kmilanez.stockmanagement;

import java.util.List;

public class StockManagement 
{
    public static void main( String[] args )
    {
        Wallet wallet = new Wallet(5);

        List<String> stocks = List.of(
            "StockA", 
            "StockA",
            "StockA",
            "StockB"
        );

        StockToMoneyConverter stockToCashConverter = new StockToMoneyConverter();
        stockToCashConverter.convert(stocks, wallet);

        System.out.println(wallet.getBalance());

    }
}
