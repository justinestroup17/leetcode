/* This program removes the duplicate integers in a sorted ascending integer array such that
 * each unique element appears only once, then returns the integer in which the new array ends */

public class RemoveDuplicates
{
    public static void main(String[] args)
    {
        int[] myArray = {1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 7, 8, 9, 9};
        System.out.print(checkRemoveDuplicates(myArray));
    }    
    public static int checkRemoveDuplicates(int[] nums)
    {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++)
        {
            /* If element is different than the next one,
            continue to iterate through array
            and place next int back in array */
            if (nums[j] != nums[i])
            {
                i++;
                nums[i] = nums[j];
            } // Otherwise, if matching, no action
        }
        return i + 1;
    }
}
