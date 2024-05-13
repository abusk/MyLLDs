package org.myllds.filesystem;

import org.myllds.filesystem.exception.DeleteException;
import org.myllds.filesystem.exception.DirectoryCreationException;
import org.myllds.filesystem.exception.NotADirectoryException;
import org.myllds.filesystem.exception.NotAFileException;
import org.myllds.filesystem.exception.PathNotFoundException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        try {
            fs.mkdir("/a/b/c");
            fs.mkdir("/a/b/d");

            List<String> ls = fs.ls("/a/b");
            System.out.println("List of directories:" + ls.toString());
            
            fs.addContentToFile("/a/b/c/d", "Hello world!");
            List<String> fls = fs.ls("/a/b/c");
            System.out.println("List of directories:" + fls.toString());

            String s = fs.readContentFromFile("/a/b/c/d");
            System.out.println("File Content: " + s);

            String cd = fs.cd("/a/b/d");
            System.out.println("cd to sub Dir:" + cd);

            String cdp = fs.cdToParent();
            System.out.println("Cd to parent from current dir:" + cdp);

            String pwd = fs.pwd();
            System.out.println("Current directory: " + pwd);

            fs.delete("/a/b/d");
            List<String> nls = fs.ls("/a/b");
            System.out.println(nls.toString());

        } catch (DirectoryCreationException | NotADirectoryException | PathNotFoundException | NotAFileException |
                 DeleteException e) {
            System.out.println(e.getMessage());
        }
    }
}