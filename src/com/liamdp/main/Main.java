package com.liamdp.main;

import com.liamdp.coord.Parser;
import com.liamdp.fileManager.FileManager;
import com.liamdp.fileManager.Grabber;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileName = "../coords.txt";
        ArrayList<String> contents = new ArrayList<>();

        try {
            contents = FileManager.grabContents(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Not able to find file, trying the grabber.");
            try {
                contents = Grabber.grab(fileName);
            } catch (FileNotFoundException | URISyntaxException ex) {
                System.err.println("Grabber was not able to find the file.");
            }
        }


        ArrayList<String> parsedCoods = Parser.parse(contents);

//        for (String coord : parsedCoods) {
//            System.out.println(coord);
//        }

        try {
            FileManager.writeFile(parsedCoods);
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
            System.err.println(e.getMessage());
        }

    }

}
