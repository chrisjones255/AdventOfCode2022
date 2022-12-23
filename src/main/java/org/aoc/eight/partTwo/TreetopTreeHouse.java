package org.aoc.eight.partTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TreetopTreeHouse {
    public static void main(String[] args) {
        BufferedReader reader, lineCheck;

        try{
            reader = new BufferedReader(new FileReader(args[0]));
            lineCheck = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            int lines = 0;
            int maxViewScore = 0;
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

            int upwardsScore = 0;
            int downwardsScore = 0;
            int leftScore = 0;
            int rightScore = 0;

            for(int i = 0; i < treeRow; i++) {
                for(int j = 0; j < trees[0].length; j++){
                    if(!(i == 0) && !(j == 0) && !(i == treeRow-1) && !(j == (trees[0].length - 1))) {  // If row or column is 0 OR If row or column is max length - viewScore = 0
                        for(int x = i-1; x >= 0; x--) { // counting upwards
                            upwardsScore++;
                            if(trees[x][j] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                break;
                            }
                        }
                        for(int x = i+1; x < treeRow; x++) { // counting downwards
                            downwardsScore++;
                            if(trees[x][j] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                break;
                            }
                        }
                        for(int x = j-1; x >= 0; x--) { // counting left
                            leftScore++;
                            if(trees[i][x] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                break;
                            }
                        }
                        for(int x = j+1; x < trees[0].length; x++) { // counting right
                            rightScore++;
                            if(trees[i][x] >= trees[i][j]){ // tree higher or the same height as target tree so target is not visible
                                break;
                            }
                        }
                        maxViewScore = Math.max(upwardsScore * downwardsScore * leftScore * rightScore, maxViewScore);
                        upwardsScore = 0;
                        downwardsScore = 0;
                        rightScore = 0;
                        leftScore = 0;
                    }
                }
            }

            System.out.println("Max view score = " + maxViewScore);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
