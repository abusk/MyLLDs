package org.myllds.librarysystem.dao.impl;

import org.myllds.librarysystem.Model.BookHoldings;
import org.myllds.librarysystem.dao.BookHoldingsDao;

import java.util.Date;
import java.util.List;

public class BookHoldingsDaoImpl implements BookHoldingsDao {
    @Override
    public void save(BookHoldings bookHoldings) {

    }

    @Override
    public List<BookHoldings> loadByDate(Date date) {
        return null;
    }

    @Override
    public List<BookHoldings> loadByMember(String member) {
        return null;
    }

    @Override
    public List<BookHoldings> loadByBook(String book) {
        return null;
    }
}
