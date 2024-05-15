package org.myllds.splitwise.strategy;

import org.myllds.splitwise.exception.EqualShareException;
import org.myllds.splitwise.exception.ExactShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.exception.PercentExceptions;

import java.util.List;

public interface SplitStrategy {
    List<Double> split(List<Double> shares, double amount, int numberOfUser) throws InvalidTransactionAmountException, EqualShareException, ExactShareException, PercentExceptions;
}
