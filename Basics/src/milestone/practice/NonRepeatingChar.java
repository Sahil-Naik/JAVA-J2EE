package milestone.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingChar {
	
	public static char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Count occurrences of each character
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first non-repeating character
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }
	
	public static void main(String[] args) {
		String userIdiot = "ttekesteaa";
		char result = findFirstNonRepeatingChar(userIdiot);
		
		if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
	}

}
