package com.liamdp.fileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class File {

    public static ArrayList<String> grabContents(String fileLocation) throws FileNotFoundException {
        Scanner scanner = new Scanner(new java.io.File(fileLocation));
        ArrayList<String> contents = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replace(" ", "");
            contents.add(line);
        }
        return contents;
    }

}
