package org.myllds.splitwise.strategy.impl;

import org.myllds.splitwise.exception.EqualShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.strategy.SplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class EqualShare implements SplitStrategy {
    @Override
    public List<Double> split(List<Double> shares, double amount, int numberOfUser) throws InvalidTransactionAmountException, EqualShareException {
        if (amount < 0) {
            throw new InvalidTransactionAmountException("Not a valid amount");
        }
        if(shares != null) {
            throw new EqualShareException("No need to provide share information");
        }
        List<Double> equalSplit = new ArrayList<>();
        for (int i = 0; i< numberOfUser; i++) {
            equalSplit.add(amount / numberOfUser);
        }
        return equalSplit;
    }
}
