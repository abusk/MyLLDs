package org.myllds.stockalert.datasources;

import org.myllds.stockalert.model.StockCompanyInfo;
import org.myllds.stockalert.model.StockData;

import java.util.List;

public interface StockDataCollector {
    StockData fetchStockData(StockCompanyInfo request);
}
