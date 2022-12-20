package org.aoc.three.partTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class rucksackReOrg {

    public static void main(String[] args) {
        BufferedReader reader;

        int badgePrioritySum = 0;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean found = false;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            String commonLetters = "";

            while (line != null) {
                String line1 = line;
                String line2 = reader.readLine();
                String line3 = reader.readLine();

                for (char c : line1.toCharArray()) {
                    if(!found) {
                        if (line2.contains(Character.toString(c)) && line3.contains(Character.toString(c))) {
                            badgePrioritySum += ((characters.indexOf(c)) + 1);
                            found = true;
                        }
                    }
                }
                found = false;

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sum of the priorities: " + badgePrioritySum);
    }
}
