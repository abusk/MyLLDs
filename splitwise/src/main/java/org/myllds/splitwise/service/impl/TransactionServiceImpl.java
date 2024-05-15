package org.myllds.splitwise.service.impl;

import org.myllds.splitwise.exception.EqualShareException;
import org.myllds.splitwise.exception.ExactShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.exception.PercentExceptions;
import org.myllds.splitwise.model.Transaction;
import org.myllds.splitwise.model.TransactionType;
import org.myllds.splitwise.model.User;
import org.myllds.splitwise.repo.TransactionRepo;
import org.myllds.splitwise.service.TransactionService;
import org.myllds.splitwise.strategy.SplitStrategy;
import org.myllds.splitwise.strategy.impl.EqualShare;
import org.myllds.splitwise.strategy.impl.ExactShare;
import org.myllds.splitwise.strategy.impl.PercentShare;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;
    private SplitStrategy splitStrategy;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public void addTransaction(Transaction transaction) throws PercentExceptions, ExactShareException, EqualShareException, InvalidTransactionAmountException {
        splitStrategy = this.selectStrategy(transaction.getType());
        List<Double> split = splitStrategy.split(transaction.getShares(), transaction.getAmount(), transaction.getNumberOfUser());
        List<User> users = transaction.getUsers();
        for (int i = 0; i < transaction.getNumberOfUser(); i++) {
            User user = users.get(i);
            Double amount = split.get(i);
            transactionRepo.addTransaction(user.getUserId(), transaction.getProvider().getUserId(), amount);
        }

    }

    private SplitStrategy selectStrategy(TransactionType type) {
        switch (type) {
            case EQUAL -> {
                return new EqualShare();
            }
            case EXACT -> {
                return new ExactShare();
            }
            case PERCENT -> {
                return new PercentShare();
            }
            case null, default -> {
                return null;
            }
        }
    }
}
