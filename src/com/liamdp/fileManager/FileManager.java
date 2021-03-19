package com.liamdp.fileManager;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManager {

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

    public static void writeFile(ArrayList<String> coords) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss'.txt'").format(new Date());
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.printf("File created: %s.%n", file.getName());
        } else {
            System.out.println("File already exists.");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String coord : coords) {
            writer.write(coord);
            writer.newLine();
        }
    }

}
