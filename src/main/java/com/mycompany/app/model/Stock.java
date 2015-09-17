package com.mycompany.app.model;

import com.mycompany.app.enumeration.StockSymbolEnum;
import com.mycompany.app.enumeration.StockTypeEnum;

/**
 * Created by verdian on 16/09/2015.
 */
public class Stock {

    private StockSymbolEnum symbol;

    private StockTypeEnum type;

    private int lastDividend;

    private int fixedDividend;

    private int parValue;

    public Stock( StockSymbolEnum symbol, StockTypeEnum type, int lastDividend, int fixedDividend, int parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }


    public StockSymbolEnum getSymbol() {
        return symbol;
    }

    public void setSymbol(StockSymbolEnum symbol) {
        this.symbol = symbol;
    }

    public StockTypeEnum getType() {
        return type;
    }

    public void setType(StockTypeEnum type) {
        this.type = type;
    }

    public int getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
    }

    public int getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(int fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public int getParValue() {
        return parValue;
    }

    public void setParValue(int parValue) {
        this.parValue = parValue;
    }
}
