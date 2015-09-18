package com.mycompany.app.engine.impl;

import com.mycompany.app.engine.SimpleStockEngine;
import com.mycompany.app.enumeration.TradeTypeEnum;
import com.mycompany.app.model.Trade;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by Angelo Verdicchio on 17/09/2015.
 */
public class SimpleStockEngineImplTest {

    private static final double DELTA = 1e-15;

    SimpleStockEngine simpleStockEngine = new SimpleStockEngineImpl();


    @Test
    public void testGetGBCE() throws Exception {

        List<Trade> tradeList = new ArrayList<Trade>();
        tradeList.add(new Trade(TradeTypeEnum.BUY,System.currentTimeMillis(),2,15));
        tradeList.add(new Trade(TradeTypeEnum.SELL,System.currentTimeMillis(),7,4));

        assertEquals(simpleStockEngine.getGBCE(tradeList), 7.745966692414834,DELTA);

        assertEquals(simpleStockEngine.getGBCE(new ArrayList<Trade>()),-1,DELTA);


    }


}
