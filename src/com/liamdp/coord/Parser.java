package com.liamdp.coord;

import java.util.ArrayList;

public class Parser {

    public static ArrayList<String> parse(ArrayList<String> coords) {
        StringBuilder stringBuilder = new StringBuilder();
        String newCoord = "";
        ArrayList<String> parsedCoords = new ArrayList<String>();
        ArrayList<Integer> indexToRemove = new ArrayList<>();
        int decCounter = 0;
        for (String coord : coords) {
            stringBuilder.setLength(0);
            decCounter = 0;
            newCoord = coord.replace("N0", "+");
            newCoord = newCoord.replace("W", "-");
            stringBuilder.append(newCoord);
            for (int i = 0; i <= stringBuilder.length() - 1; i++) {
                char c = stringBuilder.charAt(i);
                if (c == '.' && decCounter < 2) {
                    stringBuilder.deleteCharAt(i);
                    i++;
                    decCounter++;
                }
                if (c == '-') {
                    decCounter = 0;
                }
            }
            parsedCoords.add(stringBuilder.toString());

        }
        return parsedCoords;
    }

}
