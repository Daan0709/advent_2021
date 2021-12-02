package day1.puzzle2;

import day1.puzzle1.PuzzleOne;

import java.util.ArrayList;

public class PuzzleTwo {
    public static void main(String[] args) {
        ArrayList<Integer> input = PuzzleOne.retrieveData("src/day1/input");
        int numberSet = 0;
        int dataSize = input.size();
        ArrayList<Integer> numberSets = new ArrayList<>();

        for (int i = 0; i < dataSize; i++){
            if (input.size() < 3) {
                break;
            }
            for (int j = 0; j < 3; j++) {
                int numberToAdd = input.get(j);
                numberSet += numberToAdd;
            }
            numberSets.add(numberSet);
            numberSet = 0;
            input.remove(0);
        }

        int increasedCounter = PuzzleOne.getIncreasedCounter(numberSets);
        String result = String.format("The amount increased %s times", increasedCounter);
        System.out.println(result);
    }
}
