/*
 * This program determines if two strings are isomorphic meaning the characters in
 * one string can be replaced to be the equivalent of the second string. No two
 * characters may map to the same character, but a character may map to itself.
 */

import java.util.*;
class IsomorphicStrings
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        char answer = 'y';
        do
        {
        // Get user input
        System.out.println("Enter the first string followed by the enter key:");
        String stringOne = input.nextLine();

        System.out.println("Enter the second string followed by the enter key:");
        String stringTwo = input.nextLine();

        // Isomorphic strings must be same length, so if different lengths, not isomorphic
        if (stringOne.length() != stringTwo.length())
            System.out.println("The two strings \"" + stringOne + "\" and \"" + stringTwo + "\" ARE NOT isomorphic");
        
        else
        {
            // Compare strings by calling method
            if(isIsomorphic(stringOne, stringTwo))
                System.out.println("The two strings \"" + stringOne + "\" and \"" + stringTwo + "\" ARE isomorphic");
            else
                System.out.println("The strings are not isomorphic.");
        }
        
        // If user would like to repeat, continue loop, otherwise exit
        System.out.println("\nWould you like to compare strings again? \nType 'Y' for yes or 'N' for no: ");
        answer = input.next().charAt(0);
        input.nextLine(); // Take in newline char so next iteration starts with user string input
        } while ((answer == 'Y') || (answer == 'y'));
    }
    // Takes a string as input and returns a new string with modifications
    private static String transformString(String s)
    {
        // Create dictionary to store the character to index mapping for the given string
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        
        // Iterate through first string
        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            // Find out if there has been an occurence of character already
            if(!indexMapping.containsKey(c1))
                indexMapping.put(c1, i); // No mapping so use the current index for the character's first occurence
                
            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }
    // Compares two newly transformed strings and returns true for isomorphic or false otherwise
    public static boolean isIsomorphic(String s, String t)
    {
        // Compare the two newly transformed strings
        return transformString(s).equals(transformString(t));
    }
}