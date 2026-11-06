
package com.filesystem.visitor;

import com.filesystem.element.FileElement;
import com.filesystem.element.DirectoryElement;

public interface FileSystemVisitor {

    void visitFile(FileElement file);

    void visitDirectory(DirectoryElement directory);
}
