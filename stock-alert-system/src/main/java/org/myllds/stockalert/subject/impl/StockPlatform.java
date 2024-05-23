package org.myllds.stockalert.subject.impl;

import org.myllds.stockalert.datasources.StockDataCollector;
import org.myllds.stockalert.listener.StockListener;
import org.myllds.stockalert.model.StockCompanyInfo;
import org.myllds.stockalert.model.StockData;
import org.myllds.stockalert.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class StockPlatform implements Subject {

    private final StockDataCollector stockDataCollector;

    public static List<StockListener> stockListenerList = new ArrayList<>();

    public StockPlatform(StockDataCollector stockDataCollector) {
        this.stockDataCollector = stockDataCollector;
    }

    @Override
    public void addListener(StockListener listener) {
        stockListenerList.add(listener);
    }

    @Override
    public void removeListener(StockListener listener) {
        stockListenerList.remove(listener);
    }

    @Override
    public void notifyAllLister(StockData stockData) {
        for (StockListener listener : stockListenerList) {
            listener.onStockDataReceived(stockData);
        }
    }

    public void subscribeToStockOption(StockCompanyInfo request) {
        new Thread(() -> {
            while (true) {
                StockData data = stockDataCollector.fetchStockData(request);
                if (data != null) {
                    notifyAllLister(data);
                }
                try {
                    Thread.sleep(1000); // Simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
