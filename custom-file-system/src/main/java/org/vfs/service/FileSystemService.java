package org.vfs.service;

import org.vfs.model.INode;

public interface FileSystemService {
    INode fOpen(String fileName);
    void fWrite(String filename, String content);
    String fRead(String fileName);
    void fClose(String filename);
    String fRename(String fileName, String newName);
    void fRemove(String fileName);
}
