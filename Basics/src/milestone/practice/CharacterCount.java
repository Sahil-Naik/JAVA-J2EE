package milestone.practice;

import java.util.*;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "Hello, World! ooooo aaaa testtt";

        String normalizedInput = input.toLowerCase().replaceAll("[^a-zA-Z]", "");

        // Count occurrences of each character
        Map<Character, Long> characterCount = normalizedInput.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        characterCount.forEach((character, count) -> 
            System.out.println("Character: '" + character + "' Count: " + count));
    }
}