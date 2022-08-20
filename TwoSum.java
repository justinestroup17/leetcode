import java.util.Arrays;
import java.util.Scanner;

public class TwoSum
{
    public static void main(String[] args)
    {
        // Create new Scanner object
        Scanner input = new Scanner(System.in);

        // Get array size from user
        System.out.println("Enter number of digits to compare:");
        int arraySize = input.nextInt();

        // Initialize array with user's given size
        int[] inputArray = new int[arraySize];

        System.out.println("Enter each digit in the list followed by the ENTER key:");
        
        // Fill in array
        for (int i = 0; i < arraySize; i++)
        {
            inputArray[i] = input.nextInt();
        }
        // Get target from user
        System.out.println("Enter target sum of the two numbers:");
        int target = input.nextInt();

        // If target sum not found
        if (Arrays.toString(checkTwoSum(inputArray, target)) == "null")
        {
            System.out.print("Target sum not found");
        }
        else // Target sum was found
        {
            System.out.print("The indicies of the two numbers that add up to your target of " +
                target + " are: " + checkTwoSum(inputArray,target)[0] + " and " + 
                checkTwoSum(inputArray, target)[1]);
        }
    }
    public static int[] checkTwoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            // Compare target to the sum of each element in the array plus the next element
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[j] == target - nums[i])
                {
                    // Return an array with the indicies of the addends that equal the target sum
                    return new int[] {i, j};
                }
            }
        }
        // Sum equaling target not found
        return null;
    }
}