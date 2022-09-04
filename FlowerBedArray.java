/*
 * This program will determine if one can plant a certain number of flowers
 * based on the number and locations of flowers planted in an existing flower bed.
 * Flowers cannot be planted in adjacent plots.
 */

import java.util.Scanner;

public class FlowerBedArray
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] myFlowerBed = {1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0};

        System.out.print("Enter the number of flowers you would like to plant: ");
        int amount = input.nextInt();
        
        // Determine if can place amount of flowers by calling method
        if(canPlaceFlowers(myFlowerBed, amount))
            System.out.print("Can place " + amount + " flowers");
        else
            System.out.print("Cannot place " + amount + " flowers.");
    }

    public static boolean canPlaceFlowers(int[] flowerBed, int numFlowers)
    {
        int count = 0;
        // Iterate through flowerbed array to determine if can plant flowers
        for (int i = 0; i < flowerBed.length; i++)
        {
            // No flower planted at index, check if flowers are planted on left and right
            if (flowerBed[i] == 0)
            {
                // True if no element on the left, or if first element
                boolean emptyLeftPlot = (i == 0) || (flowerBed[i - 1] == 0);

                // True if no element on the right, or if last element
                boolean emptyRightPlot = (i == flowerBed.length - 1) || (flowerBed[i + 1] == 0);

                // If no adjacent flowers planted, plant flower at index i by assigning "1",
                // and add 1 to the count for number of flowers able to plant. Otherwise no action
                if (emptyLeftPlot && emptyRightPlot)
                {
                    flowerBed[i] = 1;
                    count++;
                }
            }
        }
        return count >= numFlowers;
    }
}
