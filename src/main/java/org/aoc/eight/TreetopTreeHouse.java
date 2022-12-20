package org.aoc.eight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class TreetopTreeHouse {
    public static void main(String[] args) {
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int visibleTrees = 0;

            Integer[][] trees = null;
            int treeRow = 0;

            // Read the values into the array
            while(line != null) {
                for(int i = 0; i < line.length(); i++) {
                    trees[treeRow][i] = Integer.parseInt(Character.toString(line.charAt(i)));
                }
                treeRow++;
                line = reader.readLine();
            }
            reader.close();

            for(int i = 0; i < treeRow; i++) {
                for(int j = 0; j < trees[0].length; j++){
                    // If row or column is 0 - add tree
                    // If row or column is max length - add tree
                    // If tree height == 0 - not visible
                    // for other trees in row and column - check if any are higher or the same height
                    // if any are higher or the same height, that means it's not visible from that direction - break early
                    // if all directions are higher or the same - tree is not visible
                    // otherwise count tree
                }
            }

            System.out.println("Visible trees = " + visibleTrees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
