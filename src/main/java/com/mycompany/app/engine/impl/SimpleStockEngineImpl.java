package com.mycompany.app.engine.impl;

import com.mycompany.app.engine.SimpleStockEngine;
import com.mycompany.app.enumeration.StockTypeEnum;
import com.mycompany.app.enumeration.TradeTypeEnum;
import com.mycompany.app.model.Stock;
import com.mycompany.app.model.Trade;
import com.mycompany.app.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Angelo Verdicchio on 17/09/2015.
 */
public class SimpleStockEngineImpl implements SimpleStockEngine {

    Utility utility = new Utility();

    /**
     * @param treeStockMap the list of the all trade recorded until now
     *          otherwise it will return Volume Weighted Stock Price calculate on the trade recorded in past howBefore milliseconds
     */
    @Override
    public double getDividend(Map<Integer, Stock> treeStockMap)
    {

        double result = new Double(-1);

        System.out.println("Select the Stock: ");
        for (Map.Entry<Integer, Stock> entry : treeStockMap.entrySet())
        {
            System.out.println(+entry.getKey()+". "+entry.getValue().getSymbol());
        }

        int stockIndex = utility.inInt("\n");

        if(treeStockMap.get(stockIndex) == null)
        {
            System.out.println("Input error.");
            return result;
        }

        int price = utility.inInt("Insert the price:\n ");

        if(price <=0)
        {
            System.out.println("Input error. The price cannot be less or equal to 0");
            return result;
        }

        if((treeStockMap.get(stockIndex).getType().equals(StockTypeEnum.COMMON)))
            result = (double) treeStockMap.get(stockIndex).getLastDividend() / price;
        else
            result = (double) (treeStockMap.get(stockIndex).getFixedDividend()*treeStockMap.get(stockIndex).getParValue()) / price;

        return result;
    }


    /**
     * @param treeStockMap the Map that contains all stocks
     * @return return PERatio
     */
    @Override
    public double getPERatio(Map<Integer, Stock> treeStockMap)
    {
        double result = new Double(-1);

        System.out.println("Select the Stock: ");
        for (Map.Entry<Integer, Stock> entry : treeStockMap.entrySet())
        {
            System.out.println(+entry.getKey()+". "+entry.getValue().getSymbol());
        }

        int stockIndex = utility.inInt("\n");

        if(treeStockMap.get(stockIndex) == null)
        {
            System.out.println("Input error.");
            return result;
        }

        int price = utility.inInt("Insert the price:\n ");

        if(price <=0)
        {
            System.out.println("Input error. The price cannot be less or equal to 0");
            return result;
        }

        if(treeStockMap.get(stockIndex).getFixedDividend()!=0)
            result = (double)  price/(treeStockMap.get(stockIndex).getParValue() *(treeStockMap.get(stockIndex).getFixedDividend()/100));

        return result;
    }

    /**
     * @param tradeList the list of the all trade recorded until now
     * @param howBefore the time in milliseconds before that we search the trade
     * @return -1 in case there are not trades in past howBefore milliseconds,
     *          otherwise it will return Volume Weighted Stock Price calculate on the trade recorded in past howBefore milliseconds
     */
    @Override
    public double getVolumeWeightedStockPrice(List<Trade> tradeList,long howBefore)
    {
        int sum =0;
        int sumQuantity =0;
        double result = new Double(-1);

        List<Trade> resultTradeList= getLastTrade(tradeList,howBefore);

        for(Trade trade:resultTradeList)
        {
            sum+= trade.getPrice()*trade.getQuantity();
            sumQuantity+= trade.getQuantity();
        }

        if(sum!=0)
            result = (double) sum/sumQuantity;

        return result;

    }


    /**
     * @param tradeList the list of the all trade recorded until now
     * @return GBCE All Share Index
     */
    @Override
    public double getGBCE(List<Trade> tradeList)
    {
        double result = new Double(-1);
        int product =1;

        for(Trade trade:tradeList)
        {
            product*= trade.getPrice();
        }

        if(tradeList.size()>0)
            result =  Math.sqrt(product);

        return result;
    }


    /**
     * @return The trade that is just inserted
     */
    @Override
    public Trade insertTrade()
    {
        Trade trade = new Trade();
        int swValue;

        System.out.println("Select the type of the trade: ");
        System.out.println("1. "+ TradeTypeEnum.BUY);
        System.out.println("2. "+TradeTypeEnum.SELL);

        swValue = utility.inInt("Select option: ");

        switch (swValue) {
            case 1:
                trade.setTradeType(TradeTypeEnum.BUY);
                break;
            case 2:
                trade.setTradeType(TradeTypeEnum.SELL);
                break;
            default:
                return null;
        }

        swValue = utility.inInt("Insert the price:\n ");
        if(swValue <=0)
        {
            System.out.println("Input error. The price cannot be less or equal to 0");
            return null;
        }
        trade.setPrice(swValue);

        swValue = utility.inInt("Insert the quantity:\n ");
        if(swValue <=0)
        {
            System.out.println("Input error. The quantity cannot be less or equal to 0");
            return null;
        }
        trade.setQuantity(swValue);

        trade.setTimestamp(System.currentTimeMillis());

        return trade;
    }


    private List<Trade> getLastTrade(List<Trade> tradeList,long howBefore)
    {

        long timeAgo = System.currentTimeMillis() - howBefore;
        List<Trade> resultTradeList= new ArrayList<Trade>();

        for (Trade trade: tradeList)
        {
            if (trade.getTimestamp() > timeAgo) {
                resultTradeList.add(trade);
            }
        }

        return resultTradeList;
    }

}
