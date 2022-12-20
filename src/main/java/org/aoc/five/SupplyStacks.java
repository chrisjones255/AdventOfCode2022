package org.aoc.five;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SupplyStacks {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while(line != null) {

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
