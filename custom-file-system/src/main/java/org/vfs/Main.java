package org.vfs;

import org.vfs.repository.FileRepository;
import org.vfs.service.FileSystemService;
import org.vfs.service.impl.FileSystemServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileRepository fileRepository = new FileRepository();
        FileSystemService fileSystemService = new FileSystemServiceImpl(fileRepository);
        fileSystemService.fOpen("file1");
        fileSystemService.fWrite("file1", "I am file one!");

        fileSystemService.fOpen("file1");
        fileSystemService.fWrite("file1", " and I am file one again!");
        String readFile = fileSystemService.fRead("file1");
        System.out.println(readFile);
        fileSystemService.fClose("file1");
        fileSystemService.fRename("file1", "file2");
        System.out.println(fileSystemService.fRead("file2"));

        //fileSystemService.fRemove("file2");
        fileSystemService.fOpen("file2");
        //fileSystemService.fWrite("file2", " and I am file2 now!");
        System.out.println(readFile);

    }
}