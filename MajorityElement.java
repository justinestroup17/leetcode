/*
 * This program will return the majority element
 * of an array nums of size n using a hashmap
 */

import java.util.*;

public class MajorityElement
{
    public static void main(String[] args)
    {
        int[] myNumsArray = {7, 2, 7, 8, 7, 7, 2, 4, 6, 7, 8, 7};
        System.out.println("The majority element is: " + majority(myNumsArray));
    }
    public static Map<Integer, Integer> countNums(int[] nums)
    {
        // Create a Map to keep track of # of occurrences for each number
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        // Iterate through array passed to method
        for (int num: nums)
        {
            // If found # not yet accounted for, add num to map with count 1
            if (!counts.containsKey(num))
                counts.put(num, 1);

            // Already accounted for # in list, so add 1 to count for num
            else
                counts.put(num, counts.get(num) + 1); // Plus one to existing count for num
        }
        return counts;
    }
    public static int majority(int[] nums)
    {
        // Get Map for # of occurrences for each num by calling method countNums
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
        {
            // Update majorityEntry if none exists yet or if # of occurrences is greater than majorityEntry
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
                majorityEntry = entry;
        }
        // Return key with the maximum value
        return majorityEntry.getKey();
    }
}