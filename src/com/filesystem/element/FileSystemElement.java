
package com.filesystem.element;

import com.filesystem.visitor.FileSystemVisitor;

public interface FileSystemElement {

    void accept(FileSystemVisitor visitor);
}
