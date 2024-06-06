package org.vfs.model;

public class INode {

    private String name;
    private VFile vFile;

    private VFileLock fileLock;

    public INode(String name, VFile vFile, VFileLock fileLock) {
        this.name = name;
        this.vFile = vFile;
        this.fileLock = fileLock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VFile getvFile() {
        return vFile;
    }

    public void setvFile(VFile vFile) {
        this.vFile = vFile;
    }

    public VFileLock getFileLock() {
        return fileLock;
    }

    public void setFileLock(VFileLock fileLock) {
        this.fileLock = fileLock;
    }
}
