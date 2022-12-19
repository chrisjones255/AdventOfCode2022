package org.aoc.two.partTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {
    public static void main(String[] args) {
        BufferedReader reader;

        int totalPoints = 0;
        String[] currentLine;

        // A == ROCK +1
        // B == PAPER +2
        // C == SCISSORS +3
        // X == LOSE +0
        // Y == DRAW +3
        // Z == WIN +6

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {
                currentLine = line.split(" ");
                switch (currentLine[1]) {
                    case "X":
                        switch (currentLine[0]) {
                            case "A":
                                totalPoints += 3;
                                break;
                            case "B":
                                totalPoints += 1;
                                break;
                            case "C":
                                totalPoints += 2;
                                break;
                        }
                        break;
                    case "Y":
                        switch (currentLine[0]) {
                            case "A":
                                totalPoints += 4;
                                break;
                            case "B":
                                totalPoints += 5;
                                break;
                            case "C":
                                totalPoints += 6;
                                break;
                        }
                        break;
                    case "Z":
                        switch (currentLine[0]) {
                            case "A":
                                totalPoints += 8;
                                break;
                            case "B":
                                totalPoints += 9;
                                break;
                            case "C":
                                totalPoints += 7;
                                break;
                        }
                        break;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total points: " + totalPoints);
    }
}
