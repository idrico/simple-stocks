package com.mycompany.app.model;

import com.mycompany.app.enumeration.TradeTypeEnum;

/**
 * Created by Angelo Verdicchio on 17/09/15.
 */
public class Trade {

    private TradeTypeEnum tradeType;

    private long timestamp;

    private int quantity;

    private int price;

    public Trade() {
    }

    public Trade(TradeTypeEnum tradeType, long timestamp, int quantity, int price) {
        this.tradeType = tradeType;
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.price = price;
    }

    public TradeTypeEnum getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeTypeEnum tradeType) {
        this.tradeType = tradeType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
