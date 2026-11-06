package com.filesystem.element;
import com.filesystem.visitor.FileSystemVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DirectoryElement implements FileSystemElement {

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public DirectoryElement(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Directory name cannot be empty");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(FileSystemElement element) {
        children.add(Objects.requireNonNull(element));
    }

    public List<FileSystemElement> getChildren() {
        return List.copyOf(children);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);

        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }
}
