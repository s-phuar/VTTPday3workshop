package io;

import java.io.File;

//allows you to manipulate the file path
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileMain {
    public static void main(String[] args){
        //reference to a file
        Path p = Paths.get("src/io/catinthehat.txt");
        //print name of the txt file
        System.out.printf("toString: %s\n", p.toString());

        //get the file
        File f = p.toFile();

        //get the catinthehat file information
        System.out.printf("get file absolute path: %s\n", f.getAbsolutePath());
        System.out.printf("get file name: %s\n", f.getName());
        System.out.printf("get file size: %s\n", f.length());

        //return information for non-existant file
        File cat = new File("src/io/Main.java");
        System.out.printf("get file absolute path: %s\n", cat.getAbsolutePath());
        System.out.printf("get file name: %s\n", cat.getName());
        System.out.printf("get file size: %s\n", cat.length());
    }
}
