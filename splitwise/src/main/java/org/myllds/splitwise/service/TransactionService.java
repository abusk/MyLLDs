package org.myllds.splitwise.service;

import org.myllds.splitwise.exception.EqualShareException;
import org.myllds.splitwise.exception.ExactShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.exception.PercentExceptions;
import org.myllds.splitwise.model.Transaction;

public interface TransactionService {
    void addTransaction(Transaction transaction) throws PercentExceptions, ExactShareException, EqualShareException, InvalidTransactionAmountException;
}
