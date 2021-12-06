package day2.puzzle4;

import day2.puzzle3.PuzzleThree;

import java.util.ArrayList;

public class PuzzleFour {
    public static void main(String[] args) {
        ArrayList<String> input = PuzzleThree.retrieveData("src/day2/input");
        int result = calculateHorizontalPosition(input);

        String resultString = String.format("The result is: %s", result);
        System.out.println(resultString);
    }

    public static int calculateHorizontalPosition(ArrayList<String> input){
        int horizontal = 0;
        int aim = 0;
        int depth = 0;

        for (String inputCommand : input){
            String direction = inputCommand.split(":")[0];
            int value = Integer.parseInt(inputCommand.split(":")[1]);

            if (direction.equals("forward")){
                horizontal += value;
                depth += (aim * value);
            } else {
                if (direction.equals("down")){
                    aim += value;
                } else {
                    aim -= value;
                }
            }
        }
        return horizontal * depth;
    }
}
