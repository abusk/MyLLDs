package org.myllds.splitwise.service.impl;

import org.myllds.splitwise.model.Payer;
import org.myllds.splitwise.repo.TransactionRepo;
import org.myllds.splitwise.service.DisplayService;

import java.util.Map;

public class DisplayServiceImpl implements DisplayService {
    private final TransactionRepo transactionRepo;

    public DisplayServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public String showAll() {
        Map<String, Payer> stringPayerMap = transactionRepo.showAll();
        if (stringPayerMap == null || stringPayerMap.isEmpty()) {
            return "No balances";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Payer> entry : stringPayerMap.entrySet()) {
            Payer payerWithAmount = entry.getValue();
            if(payerWithAmount.getAmount() > 0) {
                sb.append(entry.getKey() + " owes " + payerWithAmount.getPayer() + ":" + payerWithAmount.getAmount());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String showByUser(String userId) {
        Map<String, Double> stringDoubleMap = transactionRepo.ShowByUser(userId);
        if (stringDoubleMap == null || stringDoubleMap.isEmpty()) {
            return "No balances";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
            if(entry.getValue() > 0) {
                sb.append(userId + " owes " + entry.getKey() + ": " + entry.getValue());
                sb.append("\n");
            } else {
                sb.append(entry.getKey() + " owes " + userId + ": " + (-1 * entry.getValue()));
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
