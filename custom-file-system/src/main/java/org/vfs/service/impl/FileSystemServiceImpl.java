package org.vfs.service.impl;

import org.vfs.constants.Constants;
import org.vfs.exception.FileLockedException;
import org.vfs.exception.FileNotExistsException;
import org.vfs.exception.FileSizeLimitException;
import org.vfs.model.INode;
import org.vfs.model.VFile;
import org.vfs.model.VFileLock;
import org.vfs.repository.FileRepository;
import org.vfs.service.FileSystemService;

public class FileSystemServiceImpl implements FileSystemService {
    private final FileRepository fileRepository;

    public FileSystemServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public INode fOpen(String fileName) {
        INode inode = fileRepository.getInode(fileName);
        if (inode == null) {
            VFile vFile = new VFile(Constants.V_FILE_SIZE);
            VFileLock fileLock = new VFileLock(true);
            INode iNode = new INode(fileName, vFile, fileLock);
            fileRepository.addFileNode(fileName, iNode);
        } else {
            if(inode.getFileLock().isLock()) {
                throw new FileLockedException("File is Locked now!");
            }
            inode.setFileLock(new VFileLock(true));
            VFile vFile = inode.getvFile();
            inode.setvFile(vFile);
        }
        return null;
    }

    @Override
    public void fWrite(String filename, String content) {
        int length = content.length();
//        int numberOfBlocks = 1;
//        if (length > Constants.MAX_BLOCK_SIZE) {
//            numberOfBlocks = (length / Constants.MAX_BLOCK_SIZE ) + 1;
//        }

        INode inode = fileRepository.getInode(filename);
        if (inode == null) {
            throw new FileNotExistsException("File Not Exist!");
        }
        VFileLock fileLock = inode.getFileLock();
        if (fileLock.isLock()) {
            VFile vFile = inode.getvFile();
            if (vFile.getBlockSize() == Constants.V_FILE_SIZE) {
                throw new FileSizeLimitException("File size limit exceeds");
            }
            int i = 0;
            int j = length -1;
            while(i < j) {
                String sub = "";
                if(j-i < Constants.MAX_BLOCK_SIZE) {
                    sub = content.substring(i);
                    i += Constants.MAX_BLOCK_SIZE;
                } else {
                    sub = content.substring(i, i+Constants.MAX_BLOCK_SIZE);
                    i += Constants.MAX_BLOCK_SIZE;
                }
                vFile.addBlocks(sub);
            }
            inode.setvFile(vFile);
            inode.setFileLock(new VFileLock(false));
            fileRepository.addFileNode(filename, inode);
        }
    }

    @Override
    public String fRead(String fileName) {
        INode inode = fileRepository.getInode(fileName);
        if (inode == null) {
            throw new FileNotExistsException("File Not Exist!");
        }
        VFile vFile = inode.getvFile();
        return vFile.getFileContent();
    }

    @Override
    public void fClose(String filename) {
        INode inode = fileRepository.getInode(filename);
        if (inode == null) {
            throw new FileNotExistsException("File Not Exist!");
        }
        inode.setFileLock(new VFileLock(false));
        fileRepository.addFileNode(filename, inode);
    }

    @Override
    public String fRename(String fileName, String newName) {
        INode inode = fileRepository.getInode(fileName);
        if (inode == null) {
            throw new FileNotExistsException("File Not Exist!");
        }
        inode.setName(newName);
        fileRepository.removeEntry(fileName);
        fileRepository.addFileNode(newName, inode);
        return newName;
    }

    @Override
    public void fRemove(String fileName) {
        fileRepository.removeEntry(fileName);
    }
}
