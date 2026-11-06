
package com.filesystem.visitor;

import com.filesystem.element.FileElement;
import com.filesystem.element.DirectoryElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class SearchVisitor implements FileSystemVisitor {

    private final String keyword;
    private final List<String> matches = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = Objects.requireNonNull(
                keyword, "Keyword cannot be null"
        ).toLowerCase(Locale.ROOT);
    }

    @Override
    public void visitFile(FileElement file) {
        if (file.getName().toLowerCase(Locale.ROOT).contains(keyword)) {
            matches.add(file.getName());
        }
    }

    @Override
    public void visitDirectory(DirectoryElement directory) {
        // Search only files, not directories.
    }

    public List<String> getMatches() {
        return List.copyOf(matches);
    }
}
