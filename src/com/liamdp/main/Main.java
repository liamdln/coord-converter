package com.liamdp.main;

import com.liamdp.coord.Parser;
import com.liamdp.fileManager.File;
import com.liamdp.fileManager.Grabber;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileName = "../coords.txt";
        ArrayList<String> contents = new ArrayList<>();

        try {
            contents = File.grabContents(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Not able to find file, trying the grabber.");
        }

        try {
            contents = Grabber.grab(fileName);
        } catch (FileNotFoundException | URISyntaxException e) {
            System.err.println("Grabber was not able to find the file.");
        }


        ArrayList<String> parsedCoods = Parser.parse(contents);

        for (String coord : parsedCoods) {
            System.out.println(coord);
        }

    }

}
