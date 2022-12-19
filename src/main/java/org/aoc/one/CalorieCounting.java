package org.aoc.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalorieCounting {

    public static void main(String[] args) {
        BufferedReader reader;

        int currentCalories = 0;
        int mostCalories = 0;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {
                if (!line.isEmpty()) {
                    currentCalories += Integer.parseInt(line);
                } else {
                    if (currentCalories > mostCalories) {
                        mostCalories = currentCalories;
                    }
                    currentCalories = 0;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Most calories carried by a single elf: " + mostCalories);
    }
}
