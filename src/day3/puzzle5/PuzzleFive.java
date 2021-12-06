package day3.puzzle5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleFive {
    public static void main(String[] args) {
        ArrayList<String> input = retrieveData("src/day3/input");

        HashMap<String, String> frequencies = calculateMostAndLeastFrequentBits(input);
        String mostFrequent = frequencies.get("mostFrequents");
        String leastFrequent = frequencies.get("leastFrequents");

        int resultInt = Integer.parseInt(mostFrequent, 2) * Integer.parseInt(leastFrequent, 2);

        String result = String.format("The result is: %s", resultInt);
        System.out.println(result);
    }

    public static HashMap<String, String> calculateMostAndLeastFrequentBits(ArrayList<String> input) {
        String mostFrequents = "";
        String leastFrequents = "";

        for (int i = 0; i < 12; i++){
            int zeroes = 0;
            int ones = 0;
            for (String bitLine : input){
                char bit = bitLine.charAt(i);
                if (bit == '0'){
                    zeroes += 1;
                } else {
                    ones += 1;
                }
            }

            if (zeroes > ones){
                mostFrequents += "0";
                leastFrequents += "1";
            } else {
                mostFrequents += "1";
                leastFrequents += "0";
            }
        }
        HashMap<String, String> results = new HashMap<>();
        results.put("mostFrequents", mostFrequents);
        results.put("leastFrequents", leastFrequents);
        return results;
    }

    public static ArrayList<String> retrieveData(String path){
        try {
            ArrayList<String> result = new ArrayList<>();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                result.add(line);
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
}
