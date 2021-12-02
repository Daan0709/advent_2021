package day1.puzzle1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleOne {

    public static void main(String[] args) {
        ArrayList<Integer> input = retrieveData("src/day1/input");

        int increasedCounter = getIncreasedCounter(input);

        String result = String.format("The amount increased %s times", increasedCounter);
        System.out.println(result);
    }

    public static int getIncreasedCounter(ArrayList<Integer> input) {
        // The counter keeping track of how many times the number has increased,
        // set to negative one to counteract the first number counting as an increase
        int increasedCounter = -1;
        int previousNum = 0;

        for (Integer num : input){
            if (num > previousNum){
                increasedCounter += 1;
            }
            previousNum = num;
        }
        return increasedCounter;
    }

    public static ArrayList<Integer> retrieveData(String path){
        try {
            ArrayList<Integer> result = new ArrayList<>();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null){
                result.add(Integer.parseInt(line));
                line = br.readLine();
            }
            br.close();
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
