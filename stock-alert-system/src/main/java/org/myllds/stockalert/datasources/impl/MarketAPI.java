package org.myllds.stockalert.datasources.impl;

import org.myllds.stockalert.datasources.StockDataCollector;
import org.myllds.stockalert.model.StockCompanyInfo;
import org.myllds.stockalert.model.StockData;

import java.util.List;
import java.util.Map;

public class MarketAPI implements StockDataCollector {
    @Override
    public StockData fetchStockData(StockCompanyInfo request) {
        return new StockData(request.getCompany(), Math.random() * 200, 10, System.currentTimeMillis());
    }
}
