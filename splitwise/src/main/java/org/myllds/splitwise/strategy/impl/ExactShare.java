package org.myllds.splitwise.strategy.impl;

import org.myllds.splitwise.exception.ExactShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.strategy.SplitStrategy;

import java.util.List;

public class ExactShare implements SplitStrategy {
    @Override
    public List<Double> split(List<Double> shares, double amount, int numberOfUser) throws InvalidTransactionAmountException, ExactShareException {
        if (amount < 0) {
            throw new InvalidTransactionAmountException("Not a valid amount");
        }
        if(shares == null || shares.isEmpty()) {
            throw new ExactShareException("Shares information can be be empty");
        }
        double sum = shares.stream().mapToDouble(n -> n).sum();
        if(sum != amount) {
            throw new ExactShareException("Shares not sum to amount");
        }
        return shares;
    }
}
