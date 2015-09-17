package com.mycompany.app;

import com.mycompany.app.engine.SimpleStockEngine;
import com.mycompany.app.engine.impl.SimpleStockEngineImpl;
import com.mycompany.app.enumeration.StockSymbolEnum;
import com.mycompany.app.enumeration.StockTypeEnum;
import com.mycompany.app.model.Stock;
import com.mycompany.app.model.Trade;
import com.mycompany.app.utility.Utility;

import java.util.*;


public class App
{



    public static void main( String[] args ) {


        final long FIFTEEN_MINUTES = 15 * 60 * 1000;
        double result = new Double(-1);


        Utility utility = new Utility();
        List<Trade> tradeList = new ArrayList<Trade>();

        SimpleStockEngine simpleStockEngine = new SimpleStockEngineImpl();

        Map<Integer, Stock> stockMap;
        Map<Integer, Stock> treeStockMap;
        Trade trade = null;


        stockMap = new HashMap<Integer, Stock>();
        stockMap.put(1, new Stock(StockSymbolEnum.TEA, StockTypeEnum.COMMON, 0, 0, 100));
        stockMap.put(2, new Stock(StockSymbolEnum.POP, StockTypeEnum.COMMON, 8, 0, 100));
        stockMap.put(3, new Stock(StockSymbolEnum.ALE, StockTypeEnum.COMMON, 23, 0, 60));
        stockMap.put(4, new Stock(StockSymbolEnum.GIN, StockTypeEnum.PREFERRED, 8, 2, 100));
        stockMap.put(5, new Stock(StockSymbolEnum.JOE, StockTypeEnum.COMMON, 13, 0, 250));

        treeStockMap = new TreeMap<Integer, Stock>(stockMap);

        int swValue;

        while(true){
            utility.clearConsole();
        System.out.println("==============================================================");
        System.out.println("|                  Super Simple Stocks                       |");
        System.out.println("==============================================================");
        System.out.println("| Options:                                                   |");
        System.out.println("|        1. Calculate the dividend yield                     |");
        System.out.println("|        2. Calculate the P/E Ratio                          |");
        System.out.println("|        3. Record a trade                                   |");
        System.out.println("|        4. Calculate Volume Weighted Stock Price            |");
        System.out.println("|        5. Calculate the GBCE All Share Index               |");
        System.out.println("|        6. Exit                                             |");
        System.out.println("==============================================================");
        swValue = utility.inInt("Select option: ");

            utility.clearConsole();
        switch (swValue) {
            case 1:
                result = simpleStockEngine.getDividend(treeStockMap);
                if(Double.compare(result,-1)!=0)
                {
                    System.out.println("The dividend yield is:  "+result);
                }
                break;
            case 2:
                result = simpleStockEngine.getPERatio(treeStockMap);
                if(Double.compare(result,-1)!=0)
                    System.out.println("The P/E Ratio is:  "+result);
                else
                    System.out.println("The P/E Ratio could not be calculate!");
                break;
            case 3:
                trade = simpleStockEngine.insertTrade();
                if(trade!=null)
                    tradeList.add(trade);
                break;
            case 4:
                 result = simpleStockEngine.getVolumeWeightedStockPrice(tradeList,FIFTEEN_MINUTES);
                if(Double.compare(result,-1)!=0)
                    System.out.println("Volume Weighted Stock Price based on trades in past 15 minutes is: "+result);
                else
                    System.out.println("There are not trades in past 15 minutes");
                break;
            case 5:
                if(tradeList.size()!=0)
                    {
                    result =  simpleStockEngine.getGBCE(tradeList);
                    System.out.println("GBCE All Share Index based on all trades is: "+result);
                    }
                else
                    System.out.println("There are not trades");
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
            utility.pressButtonToContinue();

        }

    }





}
