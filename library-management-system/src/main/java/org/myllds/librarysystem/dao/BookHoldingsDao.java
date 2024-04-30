package org.myllds.librarysystem.dao;

import org.myllds.librarysystem.Model.BookHoldings;

import java.util.Date;
import java.util.List;

public interface BookHoldingsDao {
    public void save(BookHoldings bookHoldings);
    public List<BookHoldings> loadByDate(Date date);
    public List<BookHoldings> loadByMember(String member);
    public List<BookHoldings> loadByBook(String book);
}
