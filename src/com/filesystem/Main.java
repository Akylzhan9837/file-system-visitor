package com.filesystem;

import com.filesystem.element.FileElement;
import com.filesystem.element.DirectoryElement;
import com.filesystem.visitor.SizeCalculatorVisitor;
import com.filesystem.visitor.SearchVisitor;
public class Main {

    public static void main(String[] args) {

        DirectoryElement project = new DirectoryElement("Project");

        project.add(new FileElement("report.pdf", 500));
        project.add(new FileElement("image.png", 300));

        DirectoryElement documents = new DirectoryElement("Documents");
        documents.add(new FileElement("annual_report.docx", 700));
        documents.add(new FileElement("notes.txt", 200));

        project.add(documents);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        project.accept(sizeVisitor);

        System.out.println("Total size: "
                + sizeVisitor.getTotalSize() + " bytes");

        SearchVisitor searchVisitor = new SearchVisitor("report");
        project.accept(searchVisitor);

        System.out.println("Matching files: "
                + searchVisitor.getMatches());
    }
}
