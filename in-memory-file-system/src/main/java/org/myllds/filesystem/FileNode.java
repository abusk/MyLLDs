package org.myllds.filesystem;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class FileNode {
    private FileNode parent;
    private String path;
    private boolean isFile;
    private String content;
    private Map<String, FileNode> subDirectories;
    public FileNode(String path, boolean isFile, FileNode parent) {
        this.path = path;
        this.isFile = isFile;
        this.parent = parent;
        this.subDirectories = new HashMap<>();
    }
    public void addNewNode(String name, FileNode node) {
        subDirectories.put(name, node);
    }
    public void deleteNoe(String name) {
        subDirectories.remove(name);
    }
}
