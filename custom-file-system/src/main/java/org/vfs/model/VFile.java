package org.vfs.model;

import java.util.ArrayList;
import java.util.List;

public class VFile {
    private final List<String> blocks;

    public VFile(int numberOdBlocks) {
        this.blocks = new ArrayList<>(numberOdBlocks);
    }
    public void addBlocks(String content) {
        blocks.add(content);
    }
    public String getFileContent() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : blocks) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
    public int getBlockSize() {
        return blocks.size();
    }
}
