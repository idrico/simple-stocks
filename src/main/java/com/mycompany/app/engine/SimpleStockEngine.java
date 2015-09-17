package com.mycompany.app.engine;

import com.mycompany.app.model.Stock;
import com.mycompany.app.model.Trade;

import java.util.List;
import java.util.Map;

/**
 * Created by verdian on 17/09/2015.
 */
public interface SimpleStockEngine {

    /**
     * @param treeStockMap the list of the all trade recorded until now
     *          otherwise it will return Volume Weighted Stock Price calculate on the trade recorded in past howBefore milliseconds
     */
    double getDividend(Map<Integer, Stock> treeStockMap);

    /**
     * @param treeStockMap the Map that contains all stocks
     * @return return PERatio
     */
    double getPERatio(Map<Integer, Stock> treeStockMap);

    /**
     * @param tradeList the list of the all trade recorded until now
     * @param howBefore the time in milliseconds before that we search the trade
     * @return -1 in case there are not trades in past howBefore milliseconds,
     *          otherwise it will return Volume Weighted Stock Price calculate on the trade recorded in past howBefore milliseconds
     */
    double  getVolumeWeightedStockPrice(List<Trade> tradeList,long howBefore);


    /**
     * @param tradeList the list of the all trade recorded until now
     * @return GBCE All Share Index
     */
    double getGBCE(List<Trade> tradeList);


    /**
     * @return The trade that is just inserted
     */
    Trade insertTrade();
}
