package milestone.practice;

import java.util.*;
import java.util.stream.Collectors;

public class FrequentWords {
	public static void main(String[] args) {
		String paragraph = "This is a sample paragraph. This paragraph is meant to be a sample"
				+ " for finding the most crazy word in a paragraph. A paragraph can have many words,"
				+ " and some words may appear more crazy than others.";

		// Normalize the paragraph: convert to lower case and remove punctuation
		String normalizedParagraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

		// Split the paragraph into words
		String[] words = normalizedParagraph.split("\\s+");

		// Count the occurrences of each word
		Map<String, Long> wordCount = Arrays.stream(words)
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));

		// Find the most frequent word
		Optional<Map.Entry<String, Long>> mostFrequentWord = wordCount.entrySet().stream()
				.max(Map.Entry.comparingByValue());

		// Output the result
		if (mostFrequentWord.isPresent()) {
			System.out.println("Most frequent word: " + mostFrequentWord.get().getKey());
			System.out.println("Frequency: " + mostFrequentWord.get().getValue());
		} else {
			System.out.println("No words found.");
		}
	}
}
