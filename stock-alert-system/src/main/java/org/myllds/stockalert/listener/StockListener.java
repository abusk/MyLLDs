package org.myllds.stockalert.listener;

import org.myllds.stockalert.model.StockData;

public interface StockListener {
    void onStockDataReceived(StockData stockData);
}
