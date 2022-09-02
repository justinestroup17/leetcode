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
            System.out.println("The strings are not isomorphic.");
        
        // Strings are same length, check if isomorphic
        else
            System.out.println(isIsomorphic(stringOne, stringTwo));
        
        System.out.println("\nWould you like to compare strings again? \n Type 'Y' for yes or 'N' for no: ");
        answer = input.next().charAt(0);
        input.nextLine(); // Take in newline char so next iteration starts with user string input
        } while ((answer == 'Y') || (answer == 'y'));
    }
    private static String transformString(String s)
    {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            
            if(!indexMapping.containsKey(c1))
                indexMapping.put(c1, i);
            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }
    public static boolean isIsomorphic(String s, String t)
    {
        // Compare the two newly transformed strings
        return transformString(s).equals(transformString(t));
    }
}