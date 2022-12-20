package org.aoc.four.partTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CampCleanup {
    public static void main(String[] args) {
        BufferedReader reader;
        List<Integer> sections;
        int count = 0;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while(line != null) {
                sections = Arrays.stream(line.split(",|-")).map(Integer::parseInt).collect(Collectors.toList());
                if((sections.get(1) >= sections.get(2))) {
                    count++;
                }
                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Number of instances where cleanup overlaps: " + count);
    }
}
