package com.filesystem.visitor;

import com.filesystem.element.FileElement;
import com.filesystem.element.DirectoryElement;
public class SizeCalculatorVisitor implements FileSystemVisitor {

    private long totalSize = 0;

    @Override
    public void visitFile(FileElement file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        // Directories do not add file size.
    }

    public long getTotalSize() {
        return totalSize;
    }
}
