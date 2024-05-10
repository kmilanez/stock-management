package com.xyz.models;

/*
    This will be kind of initial config to load for stock.
    It is a replacement for StockName class & having to keep stock value at different places
 */
public enum Stock {

    STOCK_A("StockA", 1.1),
    STOCK_B("StockB", 2.0),
    STOCK_C("StockC", 2.5),
    STOCK_D("StockD", -1.1),
    STOCK_E("StockE", -3),
    ;

    private String name;
    private double value;

    Stock(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public double value() {
        return this.value;
    }
}
