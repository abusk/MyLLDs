package org.vfs.model;

public class VFileLock {
    private boolean isLock;

    public VFileLock(boolean isLock) {
        this.isLock = isLock;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }
}
