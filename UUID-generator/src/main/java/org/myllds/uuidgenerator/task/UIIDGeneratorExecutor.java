package org.myllds.uuidgenerator.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UIIDGeneratorExecutor {
    private final int numberOfThreadPool;
    private final int batchSize;
    private final long timestamp;
    private final int serverId;
    public UIIDGeneratorExecutor(int numberOfThreadPool1, int batchSize, long timestamp, int serverId) {
        this.numberOfThreadPool = numberOfThreadPool1;
        this.batchSize = batchSize;
        this.timestamp = timestamp;
        this.serverId = serverId;
    }
    public List<String> execute() {
        List<Future<List<String>>> futures = new ArrayList<>();
        try (ExecutorService executor = Executors.newFixedThreadPool(numberOfThreadPool)) {
            for(int i = 1; i<= numberOfThreadPool; i++) {
                futures.add(executor.submit(new UUIDGenerateTask(batchSize, timestamp, serverId, i)));
            }
        }
        List<String> allUUIDs = new ArrayList<>();
        for (Future<List<String>> future : futures) {
            try {
                allUUIDs.addAll(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return allUUIDs;
    }
}
