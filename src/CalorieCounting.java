// Puzzle for Day One
// Given a list of the foods each elf is carrying, find the elves with the top three most total calories
// and add their calories up

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CalorieCounting
{
    public static void main(String[] args)
            throws FileNotFoundException
    {
        File file = new File("/Users/utsavagarwal/Desktop/CalorieCountingInput.txt");
        Scanner fileReader = new Scanner(file);

        String currentValue;
        int currentCalorieCount = 0;
        int currentElfCount = 0;
        int currentMaxCalorieCount = 0;
        int currentSecondCount = 0;
        int currentThirdCount = 0;

        // true if the current line is a blank line
        boolean placeholder = false;

        while (fileReader.hasNextLine()) {
            currentValue = fileReader.nextLine();
            try
            {
                currentCalorieCount = Integer.parseInt(currentValue);
            } catch (NumberFormatException e) {
                placeholder = true;
            }

            // if it is a blank line
            if (placeholder) {
                placeholder = false;
                if (currentElfCount > currentMaxCalorieCount) {
                    currentMaxCalorieCount = currentElfCount;
                }
                else if (currentElfCount > currentSecondCount) {
                    currentSecondCount = currentElfCount;
                }
                else if (currentElfCount > currentThirdCount) {
                    currentThirdCount = currentElfCount;
                }
                System.out.println(currentElfCount);
                System.out.println("");
                currentElfCount = 0;
            }
            //68708
            //67860
            //68802
            // if it isn't a blank line
            else {
                currentElfCount = currentElfCount + currentCalorieCount;
                currentCalorieCount = 0;
            }
        }
        System.out.println(currentMaxCalorieCount);
        System.out.println(currentSecondCount);
        System.out.println(currentThirdCount);
        System.out.println(currentThirdCount+currentSecondCount+currentMaxCalorieCount);
    }
}

