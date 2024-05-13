package org.myllds.filesystem;

import org.myllds.filesystem.exception.DeleteException;
import org.myllds.filesystem.exception.DirectoryCreationException;
import org.myllds.filesystem.exception.NotADirectoryException;
import org.myllds.filesystem.exception.NotAFileException;
import org.myllds.filesystem.exception.PathNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    public static FileNode currentFileNode;
    public static FileNode root;
    public FileSystem() {
        root = new FileNode("/", false, null);
        currentFileNode = root;
    }
    public List<String> ls(String path) throws PathNotFoundException {
        FileNode next = root;
        String[] files = path.trim().split("/");
        if(files.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 1; i< files.length; i++) {
            next = next.getSubDirectories().get(files[i]);
            if(next == null) {
                throw new PathNotFoundException("path [" + path + "] does not exists.");
            }
        }
        currentFileNode = next;
        return new ArrayList<>(currentFileNode.getSubDirectories().keySet());
    }

    public void mkdir(String path) throws DirectoryCreationException, NotADirectoryException {
        FileNode next = root;
        FileNode prv;
        String[] files = path.trim().split("/");
        if(files.length == 0) {
            throw new DirectoryCreationException("Cant create empty path directory");
        }
        for(int i = 1; i< files.length; i++) {
            prv = next;
            next = next.getSubDirectories().get(files[i]);
            if (next != null && next.isFile()) {
                throw new NotADirectoryException("Path contains a file +[" + files[i] + "]");
            }
            if(next == null) {
                FileNode newNode = new FileNode(prv.getPath() + "/" + files[i], false, prv);
                prv.addNewNode(files[i], newNode);
                next = newNode;
            }
        }
        System.out.println("Created directory on path [" + path  + "]");
    }

    public void addContentToFile(String filePath, String content) throws DirectoryCreationException {
        FileNode next = root;
        FileNode prv = root;
        String[] files = filePath.trim().split("/");
        if(files.length == 0) {
            throw new DirectoryCreationException("Cant be an empty path");
        }
        for(int i = 1; i< files.length; i++) {
            prv = next;
            next = next.getSubDirectories().get(files[i]);
            if(next == null) {
                FileNode newNode = new FileNode(prv.getPath() + "/" + files[i], false, prv);
                prv.addNewNode(files[i], newNode);
                next = newNode;
            }
        }
        FileNode fileNode = new FileNode(prv.getPath() + "/" + files[files.length-1], true, prv);
        fileNode.setContent(content);
        prv.addNewNode(files[files.length-1], fileNode);
        System.out.println("Added file content successfully as path [" + filePath + "]");
    }

    public String readContentFromFile(String filePath) throws DirectoryCreationException, PathNotFoundException, NotAFileException {
        FileNode next = root;
        String[] files = filePath.trim().split("/");
        if(files.length == 0) {
            throw new DirectoryCreationException("Cant be an empty path");
        }
        for (int i = 1; i< files.length; i++) {
            next = next.getSubDirectories().get(files[i]);
            if(next == null) {
                throw new PathNotFoundException("path [" + filePath + "] does not exists.");
            }
        }
        if (next.isFile()){
            return next.getContent();
        } else {
            throw new NotAFileException("the path [" + filePath + "] does not have any file");
        }
    }

    public String cdToParent() {
        if (currentFileNode == null) {
            return "/";
        } else {
           currentFileNode = currentFileNode.getParent();
            return currentFileNode.getPath();
        }
    }

    public String cd(String filePath) throws PathNotFoundException {
        FileNode next = root;
        String[] files = filePath.trim().split("/");
        if(files.length == 0) {
            return root.getPath();
        }
        for (int i = 1; i< files.length; i++) {
            next = next.getSubDirectories().get(files[i]);
            if(next == null) {
                throw new PathNotFoundException("path [" + filePath + "] does not exists.");
            }
            currentFileNode = next;
        }
        return currentFileNode.getPath();
    }

    public String pwd() {
        return currentFileNode.getPath();
    }
    public void delete(String path) throws DeleteException, PathNotFoundException {
        FileNode next = root;
        String[] files = path.trim().split("/");
        if(files.length == 0) {
            throw new DeleteException("Don't have permission to delete root directory");
        }
        for (int i = 1; i< files.length-1; i++) {
            next = next.getSubDirectories().get(files[i]);
            if(next == null) {
                throw new PathNotFoundException("path [" + path + "] does not exists.");
            }
        }
        next.deleteNoe(files[files.length-1]);
        System.out.println("Deleted path [" + path + "] successfully" );
    }
}
