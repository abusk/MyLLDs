package org.vfs.repository;

import org.vfs.model.INode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileRepository {
    private final Map<String, INode> fileRepo;

    public FileRepository() {
        this.fileRepo = new ConcurrentHashMap<>();
    }
    public INode getInode(String fileName) {
        return fileRepo.get(fileName);
    }
    public void addFileNode(String file, INode iNode) {
        fileRepo.put(file, iNode);
    }
    public void removeEntry(String fileName) {
        fileRepo.remove(fileName);
    }
}
