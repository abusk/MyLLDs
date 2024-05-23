package org.myllds;

import org.myllds.stockalert.datasources.impl.MarketAPI;
import org.myllds.stockalert.listener.StockListener;
import org.myllds.stockalert.listener.impl.GreaterPriceListener;
import org.myllds.stockalert.listener.impl.LessPriceListener;
import org.myllds.stockalert.model.StockCompanyInfo;
import org.myllds.stockalert.subject.impl.StockPlatform;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MarketAPI marketAPI = new MarketAPI();

        // Create alert listeners
        Map<String, Integer> companyWithThreshold = new HashMap<>();
        companyWithThreshold.put("APPLE", 100);
        companyWithThreshold.put("GOOGLE", 40);

        StockListener applAlert = new GreaterPriceListener(companyWithThreshold);
        StockListener googlAlert = new LessPriceListener(companyWithThreshold);

        // Attach observers to the market API
        StockPlatform stockPlatform = new StockPlatform(new MarketAPI());
        stockPlatform.addListener(applAlert);
        stockPlatform.addListener(googlAlert);

        stockPlatform.subscribeToStockOption(new StockCompanyInfo("APPLE"));
        stockPlatform.subscribeToStockOption(new StockCompanyInfo("GOOGLE"));
    }
}