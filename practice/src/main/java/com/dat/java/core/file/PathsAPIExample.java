package com.dat.java.core.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class PathsAPIExample {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/java/com/dat/java/core/file/readme.txt");
        System.out.println("File name: " + path.getFileName());

        //How to check if a file exists
        System.out.println("File exists: " + path.toFile().exists());
        boolean exists = Files.exists(path);
        System.out.println("File exists: " + exists);

        //How to get the last modified date of a file
        FileTime lastModified = Files.getLastModifiedTime(path);
        System.out.println("Last modified: " + lastModified);

        //Writing & Reading Files
        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8
        System.out.println("utfFile = " + utfFile);

        Path iso88591File = Files.createTempFile("some", ".txt");
        Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
        System.out.println("iso88591File = " + iso88591File);
    }
}
