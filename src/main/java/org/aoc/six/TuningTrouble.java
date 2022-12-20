package org.aoc.six;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class TuningTrouble {

    public static void main(String[] args) {
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            HashSet<Character> markerCandidate = new HashSet<>();
            int processedChars = 0;
            boolean found = false;
            while(line != null) {
                for (int i = 0; i < (line.length()-4); i++) {
                    if (!found) {
                        for(int j = i; j < i+4; j++) {
                            markerCandidate.add(line.charAt(j));
                        }
                        System.out.println("Block " + i + ": " + markerCandidate);
                        if(markerCandidate.size() == 4) {
                            found = true;
                            processedChars = i + 4;
                        }
                        markerCandidate.clear();
                    }
                }

                line = reader.readLine();
            }
            reader.close();
            System.out.println("Processed characters = " + processedChars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
