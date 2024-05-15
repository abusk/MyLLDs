package org.myllds.splitwise.repo;

import org.myllds.splitwise.model.Payer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionRepo {
    private final Map<String, Map<String, Double>> transactions;
    public TransactionRepo() {
        transactions = new ConcurrentHashMap<>();
    }
    public void addTransaction(String payee, String payer, double amount) {
        if (payee.equalsIgnoreCase(payer)) {
            return;
        }
        Map<String, Double> payeeAmounts = transactions.get(payee);
        if (payeeAmounts == null) {
            Map<String, Double> newPayers = new HashMap<>();
            newPayers.put(payer, amount);
            transactions.put(payee, newPayers);
            return;
        }
        Double payerAmount = payeeAmounts.get(payer);
        if(payerAmount == null) {
            payeeAmounts.put(payer, amount);
        } else {
           payeeAmounts.put(payer, amount + payerAmount);
        }
        transactions.put(payee, payeeAmounts);
    }

    public Map<String, Double> ShowByUser(String userId) {
        Map<String, Double> owesByUser = new HashMap<>();

        Map<String, Double> payersWithAmount = transactions.get(userId);
        if (payersWithAmount == null) {
            return null;
        }
        for (Map.Entry<String, Double> entry : payersWithAmount.entrySet()) {
            Map<String, Double> payersBecomePayee = transactions.get(entry.getKey());
            if (payersBecomePayee == null) {
               if (entry.getValue() > 0) {
                   owesByUser.put(entry.getKey(), entry.getValue());
               }
            } else {
                Double payeeAmount = payersBecomePayee.get(userId);
                if (payeeAmount == null) {
                    payeeAmount = 0.0;
                }
                Double payersAmount = entry.getValue();
                double owes = payersAmount - payeeAmount;
                if (owes != 0.0) {
                    owesByUser.put(entry.getKey(), owes);
                }
            }
        }
        return owesByUser;
    }

    public Map<String, Payer> showAll() {
        Map<String, Payer> allShow = new HashMap<>();
        for (Map.Entry<String, Map<String, Double>> entry : transactions.entrySet()) {
            Map<String, Double> allPayer = this.ShowByUser(entry.getKey());
            for (Map.Entry<String, Double> allPayerEntry: allPayer.entrySet()) {
                if(allPayerEntry.getValue() > 0) {
                    Payer payer = new Payer(allPayerEntry.getKey(), allPayerEntry.getValue());
                    allShow.put(entry.getKey(), payer);
                }
            }
        }
        return allShow;
    }
}
