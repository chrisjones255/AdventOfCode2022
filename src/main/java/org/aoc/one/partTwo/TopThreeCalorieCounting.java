package org.aoc.one.partTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopThreeCalorieCounting {
    public static void main(String[] args) {
        BufferedReader reader;

        int topThreeTotal = 0;
        int currentCalories = 0;

        List<Integer> caloriesForEachElf = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {
                if (!line.isEmpty()) {
                    currentCalories += Integer.parseInt(line);
                } else {
                    caloriesForEachElf.add(currentCalories);
                    currentCalories = 0;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(caloriesForEachElf, Collections.reverseOrder());
        for(int i = 0; i < 3; i++) {
            topThreeTotal += caloriesForEachElf.get(i);
        }

        System.out.println(topThreeTotal);
    }
}
