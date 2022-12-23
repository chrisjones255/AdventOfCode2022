package org.aoc.nine;


import com.sun.tools.javac.util.Pair;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ropeBridge {

    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            List<Pair<Point, Point>> positions = new ArrayList<>(); // [((0,0)(0,0)),((0,0)(0,0))]
            String[] instruction = null;

            Point currentHead = new Point(0, 0);
            Point currentTail = new Point(0, 0);
            positions.add(Pair.of(currentHead, currentTail));

            Point newHead = new Point(0, 0);;
            Point newTail = new Point(0, 0);;

            int lineNum = 0;

            while(line != null) {
                lineNum++;
                instruction = line.split(" ");

                switch (instruction[0]) {
                    case ("U"):
                        for (int i = 0; i < Integer.parseInt(instruction[1]); i++) {
                            newHead.setLocation(currentHead.x, currentHead.y + 1);
                            if (newHead.distanceSq(currentTail) > 2) {  // New head must be above tail since it's moved
                                newTail.setLocation(newHead.x, newHead.y - 1);
                            } else {
                                newTail.setLocation(currentTail);
                            }
                            currentHead.setLocation(newHead);
                            currentTail.setLocation(newTail);
                            positions.add(Pair.of(newHead, newTail));
                        }
                        break;
                    case ("D"):
                        for (int i = 0; i < Integer.parseInt(instruction[1]); i++) {
                            newHead.setLocation(currentHead.x, currentHead.y - 1);
                            if (newHead.distanceSq(currentTail) > 2) {  // New head must be below tail since it's moved
                                newTail.setLocation(newHead.x, newHead.y + 1);
                            } else {
                                newTail.setLocation(currentTail);
                            }
                            currentHead.setLocation(newHead);
                            currentTail.setLocation(newTail);
                            positions.add(Pair.of(newHead, newTail));
                        }
                        break;
                    case ("L"):
                        for (int i = 0; i < Integer.parseInt(instruction[1]); i++) {
                            newHead.setLocation(currentHead.x - 1, currentHead.y);
                            if (newHead.distanceSq(currentTail) > 2) {
                                newTail.setLocation(newHead.x + 1, newHead.y);
                            } else {
                                newTail.setLocation(currentTail);
                            }
                            currentHead.setLocation(newHead);
                            currentTail.setLocation(newTail);
                            positions.add(Pair.of(newHead, newTail));
                        }
                        break;
                    case ("R"):
                        for (int i = 0; i < Integer.parseInt(instruction[1]); i++) {
                            newHead.setLocation(currentHead.x + 1, currentHead.y);
                            if (newHead.distanceSq(currentTail) > 2) {
                                newTail.setLocation(newHead.x - 1, newHead.y);
                            } else {
                                newTail.setLocation(currentTail);
                            }
                            currentHead.setLocation(newHead);
                            currentTail.setLocation(newTail);
                            positions.add(Pair.of(newHead, newTail));
                        }
                        break;
                }
                System.out.println(lineNum + ". Movement: " + line + ", current positions: " + positions.get(positions.size()-1).toString());
                line = reader.readLine();
            }
            reader.close();

            for(Pair<Point, Point> position : positions) {
                System.out.println("Position: " + position);
            }

            HashSet<Point> uniqueTailPositions = new HashSet<>();
            for (Pair<Point, Point> position : positions) {
                // System.out.println("Is the new position the same as the existing one: " + (uniqueTailPositions.contains(position)));
                uniqueTailPositions.add(position.snd);
            }
            System.out.println("Unique tail positions: " + uniqueTailPositions);

            System.out.println("Number of unique positions of tail: " + uniqueTailPositions.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // start at ((0,0),(0,0)) for both heads and tails
    // update the heads positions - one movement at a time
    // check whether tail needs to move because heads is no longer adjacent
    // work out where the tail needs to move to
    // record the position of the tail
    // put the positions of the tail into a set
    // check the size of the set
}
