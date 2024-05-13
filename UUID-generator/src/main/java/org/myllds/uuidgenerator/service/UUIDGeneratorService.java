package org.myllds.uuidgenerator.service;

import org.myllds.uuidgenerator.task.UIIDGeneratorExecutor;

import java.util.List;

public class UUIDGeneratorService {

    private final int serverId;
    private final int numberOfThreads;
    private final int batchSize;

    public UUIDGeneratorService( int serverId, int numberOfThreads, int batchSize) {
        this.serverId = serverId;
        this.numberOfThreads = numberOfThreads;
        this.batchSize = batchSize;
    }

    public List<String> generateUUIDs(long timestamp) {
        UIIDGeneratorExecutor executor = new UIIDGeneratorExecutor(numberOfThreads, batchSize, timestamp, serverId);
        return executor.execute();
    }
}
