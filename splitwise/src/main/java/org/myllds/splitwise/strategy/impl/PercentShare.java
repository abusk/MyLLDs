package org.myllds.splitwise.strategy.impl;

import org.myllds.splitwise.exception.ExactShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.exception.PercentExceptions;
import org.myllds.splitwise.strategy.SplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class PercentShare implements SplitStrategy {
    @Override
    public List<Double> split(List<Double> shares, double amount, int numberOfUser) throws InvalidTransactionAmountException, PercentExceptions {
        if (amount < 0) {
            throw new InvalidTransactionAmountException("Not a valid amount");
        }
        if(shares == null || shares.isEmpty()) {
            throw new PercentExceptions("Shares information can be be empty");
        }
        double sum = shares.stream().mapToDouble(n -> n).sum();
        if (sum != 100.00) {
            throw new PercentExceptions("Shares not sum to 100%");
        }
        List<Double> splits = new ArrayList<>();
        for (Double share : shares) {
            splits.add((share * amount)/100);
        }
        return splits;
    }
}
