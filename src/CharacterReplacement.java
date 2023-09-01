import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        // Create a map to keep track of character counts in the string.
        Map<Character, Integer> charCount = new HashMap<>();

        // Create variables to store the top frequency of characters
        // and to keep track of the longest substring.
        int topFrequency = 0;
        int longest = 0;

        // Create variables to act as pointers in the string loop.
        int left = 0;
        int right = 0;

        // Loop through characters.
        while (right < s.length()) {
            // Assign the character to the 'right' pointer.
            char rightChar = s.charAt(right);

            // Add the right pointer character to the map and track the appearance frequency.
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

            // Compare between the right character's frequency and the top frequency,
            // and assign the larger value to the top frequency.
            topFrequency = Math.max(topFrequency, charCount.get(rightChar));

            // Check if the characters to be changed (top frequency) are more than K.
            while ((right - left + 1) - topFrequency > k) {
                // If they are, move the left pointer to the next character in the string
                // and reduce its frequency number in the map.
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }

            // If not, compare between the longest value set and the current longest substring you have,
            // then reassign it to be the current longest substring value.
            longest = Math.max(longest, (right - left + 1));

            // Increment the 'right' pointer counter.
            right++;
        }

        // Return the longest substring value.
        return longest;
    }

    public static void main(String[] args) {
        CharacterReplacement solution = new CharacterReplacement();
        String string = "ABAB";
        int number = 2;
        System.out.println(solution.characterReplacement(string, number)); // Output: 4
    }
}
