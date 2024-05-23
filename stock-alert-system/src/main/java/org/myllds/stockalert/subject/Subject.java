package org.myllds.stockalert.subject;

import org.myllds.stockalert.listener.StockListener;
import org.myllds.stockalert.model.StockData;

public interface Subject {
    void addListener(StockListener listener);
    void removeListener(StockListener listener);
    void notifyAllLister(StockData stockData);
}
