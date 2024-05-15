package org.myllds.splitwise;

import org.myllds.splitwise.exception.EqualShareException;
import org.myllds.splitwise.exception.ExactShareException;
import org.myllds.splitwise.exception.InvalidTransactionAmountException;
import org.myllds.splitwise.exception.PercentExceptions;
import org.myllds.splitwise.model.Transaction;
import org.myllds.splitwise.model.TransactionType;
import org.myllds.splitwise.model.User;
import org.myllds.splitwise.repo.TransactionRepo;
import org.myllds.splitwise.service.DisplayService;
import org.myllds.splitwise.service.TransactionService;
import org.myllds.splitwise.service.impl.DisplayServiceImpl;
import org.myllds.splitwise.service.impl.TransactionServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws PercentExceptions, ExactShareException, EqualShareException, InvalidTransactionAmountException {
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");
        User u5 = new User("u5");
        TransactionRepo transactionRepo = new TransactionRepo();

        DisplayService displayService = new DisplayServiceImpl(transactionRepo);
        String sAll1 = displayService.showAll();
        System.out.println(sAll1);
        String s1 = displayService.showByUser(u1.getUserId());
        System.out.println(s1);

        TransactionService transactionService = new TransactionServiceImpl(transactionRepo);
        Transaction t1 = new Transaction(u1, 1000, 4, Arrays.asList(u1, u2, u3, u4), TransactionType.EQUAL, null);
        transactionService.addTransaction(t1);

        String s2 = displayService.showByUser(u4.getUserId());
        System.out.println(s2);

        String s3 = displayService.showByUser(u1.getUserId());
        System.out.println(s3);

        Transaction t2 = new Transaction(u1, 1250, 2, Arrays.asList(u2, u3), TransactionType.EXACT, Arrays.asList(370.00, 880.00));
        transactionService.addTransaction(t2);

        String sAll2 = displayService.showAll();
        System.out.println(sAll2);

        Transaction t3 = new Transaction(u4, 1200, 4, Arrays.asList(u1, u2, u3, u4), TransactionType.PERCENT, Arrays.asList(40.00, 20.00, 20.00, 20.00));
        transactionService.addTransaction(t3);

        String s4 = displayService.showByUser(u1.getUserId());
        System.out.println(s4);

        String sAll3 = displayService.showAll();
        System.out.println(sAll3);
    }
}