package org.myllds.stockalert.listener.impl;

import org.myllds.stockalert.listener.StockListener;
import org.myllds.stockalert.model.StockData;

import java.util.Map;

public class GreaterPriceListener implements StockListener {
    private final Map<String, Integer> companyWithThreshold;

    public GreaterPriceListener(Map<String, Integer> companyWithThreshold) {
        this.companyWithThreshold = companyWithThreshold;
    }

    @Override
    public void onStockDataReceived(StockData stockData) {
        Integer threshold = companyWithThreshold.get(stockData.getCompany());
        if (stockData.getPrice() > threshold) {
            System.out.println("Alert: " + stockData.getCompany() + " price is greater than " + threshold);
        }
    }
}
