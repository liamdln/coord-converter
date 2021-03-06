package com.liamdp.fileManager;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grabber {

    public static ArrayList<String> grab(String fileLocation) throws FileNotFoundException, URISyntaxException {

        String fileName = fileLocation.replace("../", "./");
        System.out.println(fileName);

        Scanner scanner = new Scanner(new java.io.File(fileName));
        ArrayList<String> contents = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replace(" ", "");
            contents.add(line);
        }
        return contents;
    }

}
