package org.aoc.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class rucksackReOrg {

    public static void main(String[] args) {
        BufferedReader reader;

        int prioritySum = 0;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean counted = false;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {
                String compartment1 = line.substring(0, line.length() / 2);
                String compartment2 = line.substring(line.length() / 2);

                for (char c : compartment1.toCharArray()) {
                    if(!counted){
                        if (compartment2.contains(Character.toString(c))) {
                            prioritySum += ((characters.indexOf(c)) + 1);
                            counted = true;
                        }
                    }
                }
                counted = false;

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sum of the priorities: " + prioritySum);
    }
}
