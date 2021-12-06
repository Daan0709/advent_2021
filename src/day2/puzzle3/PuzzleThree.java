package day2.puzzle3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleThree {
    public static void main(String[] args) {
        ArrayList<String> input = retrieveData("src/day2/input");
        int result = calculateHorizontalAndDepth(input);

        String resultString = String.format("The result is: %s", result);
        System.out.println(resultString);
    }

    public static ArrayList<String> retrieveData(String path){
        try {
            ArrayList<String> result = new ArrayList<>();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                String[] splitLine = line.split(" ");
                result.add(splitLine[0] + ":" + Integer.parseInt(splitLine[1]));
                line = br.readLine();
            }
            br.close();
            return result;
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static int calculateHorizontalAndDepth(ArrayList<String> input){
        int horizontal = 0;
        int depth = 0;

        for (String movement : input){
            String direction = movement.split(":")[0];
            int value = Integer.parseInt(movement.split(":")[1]);
            if (direction.equals("forward")){
                horizontal += value;
            } else {
                if (direction.equals("down")){
                    depth += value;
                } else {
                    depth -= value;
                }
            }
        }

        return horizontal * depth;
    }
}
