package org.aoc.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class RockPaperScissors {
    public static void main(String[] args) {
        BufferedReader reader;

        int totalPoints = 0;
        String[] currentLine;

        // A & X == ROCK
        // B & Y == PAPER
        // C & Z == SCISSORS

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            while (line != null) {
                currentLine = line.split(" ");
                if (currentLine[1].equals("X")) {
                    if (currentLine[0].equals("A")) {
                        totalPoints += 4;
                    } else if (currentLine[0].equals("B")) {
                        totalPoints += 1;
                    } else if (currentLine[0].equals("C")) {
                        totalPoints += 7;
                    }
                } else if (currentLine[1].equals("Y")) {
                    if (currentLine[0].equals("A")) {
                        totalPoints += 8;
                    } else if (currentLine[0].equals("B")) {
                        totalPoints += 5;
                    } else if (currentLine[0].equals("C")) {
                        totalPoints += 2;
                    }
                } else if (currentLine[1].equals("Z")) {
                    if (currentLine[0].equals("A")) {
                        totalPoints += 3;
                    } else if (currentLine[0].equals("B")) {
                        totalPoints += 9;
                    } else if (currentLine[0].equals("C")) {
                        totalPoints += 6;
                    }
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
