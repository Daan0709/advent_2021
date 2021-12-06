package day3.puzzle6;

import day3.puzzle5.PuzzleFive;

import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleSix {
    public static void main(String[] args) {
        ArrayList<String> input = PuzzleFive.retrieveData("src/day3/input");
        HashMap<String, String> resultMap = calculateOxygenAndCO2(input);
        String oxygen = resultMap.get("oxygen");
        String co2 = resultMap.get("co2");

        int result = Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2);
        String resultString = String.format("The result is: %s", result);
        System.out.println(resultString);
    }

    public static HashMap<String, String> calculateOxygenAndCO2(ArrayList<String> input){
        String oxygen = "";
        String co2 = "";
        ArrayList<String> inputClone = (ArrayList<String>) input.clone();
        HashMap<String, String> frequencies = PuzzleFive.calculateMostAndLeastFrequentBits(input);
        String mostFrequent = frequencies.get("mostFrequents");
        String leastFrequent = frequencies.get("leastFrequents");

        while (inputClone.size() > 1) {
            for (int i = 0; i < 12; i++) {
                inputClone = removeWrongBinaries(inputClone, mostFrequent, i);
            }
        }

        oxygen = inputClone.get(0);
        inputClone = input;

        while (inputClone.size() > 1) {
            for (int i = 0; i < 12; i++) {
                inputClone = removeWrongBinaries(inputClone, leastFrequent, i);
            }
        }

        co2 = inputClone.get(0);
        HashMap<String, String> result = new HashMap<>();
        result.put("oxygen", oxygen);
        result.put("co2", co2);
        return result;
    }

    private static ArrayList<String> removeWrongBinaries(ArrayList<String> input, String frequency, int index){
        ArrayList<String> result = new ArrayList<>();
        if (input.size() == 1){
            return input;
        }
        for (String binaryNumber : input) {
            if (binaryNumber.charAt(index) == frequency.charAt(index)){
                result.add(binaryNumber);
            }
        }

        return result;
    }
}
