package org.myllds.uuidgenerator.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class UUIDGenerateTask implements Callable<List<String>> {
    private long batchSize;
    private long timestamp;
    private long threadId;

    private long serverId;

    public UUIDGenerateTask(int batchSize, long timestamp, long serverId, int threadId) {
        this.batchSize = batchSize;
        this.timestamp = timestamp;
        this.threadId = threadId;
        this.serverId = serverId;
    }

    @Override
    public List<String> call() throws Exception {
        List<String> uids = new ArrayList<>();
        for(int i = 1; i <= batchSize; i++) {
            long timeStampIdPart = timestamp << 24;
            long serverIdPart = serverId << 16;
            long timeStampAndServerId = timeStampIdPart | serverIdPart;
            long threadIdPart = threadId << 12;
            long threadIdWithCounter = threadIdPart | i;
            long uid = timeStampAndServerId | threadIdWithCounter;
            uids.add(Long.toHexString(uid));

        }
        return uids;
    }
}
