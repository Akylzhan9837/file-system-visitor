
package com.filesystem.visitor;

import com.filesystem.element.DirectoryElement;
import com.filesystem.element.FileElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileSystemVisitorTest {

    @Test
    void shouldCalculateSingleFileSize() {
        FileElement file = new FileElement("test.txt", 500);
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();

        file.accept(visitor);

        assertEquals(500, visitor.getTotalSize());
    }

    @Test
    void shouldCalculateNestedDirectorySize() {
        DirectoryElement root = new DirectoryElement("Root");
        root.add(new FileElement("a.txt", 100));

        DirectoryElement nested = new DirectoryElement("Nested");
        nested.add(new FileElement("b.txt", 200));
        root.add(nested);

        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        root.accept(visitor);

        assertEquals(300, visitor.getTotalSize());
    }

    @Test
    void shouldSearchFilesByKeyword() {
        DirectoryElement root = new DirectoryElement("Root");
        root.add(new FileElement("report.pdf", 100));
        root.add(new FileElement("image.png", 200));

        SearchVisitor visitor = new SearchVisitor("report");
        root.accept(visitor);

        assertEquals(1, visitor.getMatches().size());
        assertEquals("report.pdf", visitor.getMatches().get(0));
    }

    @Test
    void shouldSearchIgnoringCase() {
        FileElement file = new FileElement("REPORT.PDF", 100);
        SearchVisitor visitor = new SearchVisitor("report");

        file.accept(visitor);

        assertEquals(1, visitor.getMatches().size());
    }

    @Test
    void shouldReturnEmptySearchResults() {
        FileElement file = new FileElement("image.png", 100);
        SearchVisitor visitor = new SearchVisitor("report");

        file.accept(visitor);

        assertTrue(visitor.getMatches().isEmpty());
    }

    @Test
    void shouldRejectNegativeFileSize() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new FileElement("test.txt", -1)
        );
    }

    @Test
    void shouldRejectEmptyFileName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new FileElement("", 100)
        );
    }

    @Test
    void shouldRejectNullDirectoryChild() {
        DirectoryElement directory = new DirectoryElement("Root");

        assertThrows(
                NullPointerException.class,
                () -> directory.add(null)
        );
    }
}
