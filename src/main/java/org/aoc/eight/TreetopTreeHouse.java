package org.aoc.eight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class TreetopTreeHouse {
    public static void main(String[] args) {
        BufferedReader reader, lineCheck;

        try{
            reader = new BufferedReader(new FileReader(args[0]));
            lineCheck = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int visibleTrees = 0;
            int lines = 0;
            while(lineCheck.readLine() != null) lines++;

            Integer[][] trees = new Integer[lines][line.length()];
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
            lineCheck.close();

            // Show that I've got the right array:
            System.out.println("Array Structure:");
            for(int i = 0; i<lines; i++) {
                System.out.println(Arrays.toString(trees[i]));
            }
            System.out.println("Row length: " + trees[0].length);
            System.out.println("Number of rows: " + lines);

            for(int i = 0; i < treeRow; i++) {
                for(int j = 0; j < trees[0].length; j++){
                    if((i == 0) || (j == 0) || (i == treeRow-1) || (j == (trees[0].length - 1))) {  // If row or column is 0 OR If row or column is max length - add tree
                        visibleTrees++;
                    } else {
                        boolean visibleFromTop = true;
                        boolean visibleFromBottom = true;
                        boolean visibleFromLeft = true;
                        boolean visibleFromRight = true;
                        for(int x = 0; x < i; x++) { // counting down from top
                            if(trees[x][j] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                visibleFromTop = false;
                                break;
                            }
                        }
                        for(int x = i+1; x < treeRow; x++) { // counting down from tree
                            if(trees[x][j] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                visibleFromBottom = false;
                                break;
                            }
                        }
                        for(int x = 0; x < j; x++) { // counting across from start
                            if(trees[i][x] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                visibleFromLeft = false;
                                break;
                            }
                        }
                        for(int x = j+1; x < trees[0].length; x++) { // counting across from tree
                            if(trees[i][x] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                visibleFromRight = false;
                                break;
                            }
                        }
                        if(visibleFromTop || visibleFromBottom || visibleFromLeft || visibleFromRight) {
                            visibleTrees++;
                        }
                        // for other trees in row and column - check if any are higher or the same height
                        // if any are higher or the same height, that means it's not visible from that direction - break early
                        // if all directions are higher or the same - tree is not visible
                        // otherwise count tree
                    }
                }
            }

            System.out.println("Visible trees = " + visibleTrees);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
