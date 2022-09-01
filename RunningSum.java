/*
 * This program outputs the running sum 
 * of the elements of a given array
 */
public class RunningSum
{
    public static void main(String[] args)
    {
        int[] myArray = {1, 2, 3, 4};
        // Output array after called by method
        displayArray(checkRunningSum(myArray));
    }
    public static int[] checkRunningSum(int[] nums)
    {
        // Initialize new array with same length as nums array
        int[] newArray = new int[nums.length];

        // 1st element of new array is the same as 1st element of nums array
        newArray[0] = nums[0];

        // New element equals next element plus running sum
        for (int i = 1; i < nums.length; i++)
        {
            newArray[i] = nums[i] + newArray[i - 1];
        }
        return newArray;
    }
    public static void displayArray(int[] nums)
    {
        // Iterate through array and print to screen
        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }
}