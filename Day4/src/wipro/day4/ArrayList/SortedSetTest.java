package wipro.day4.ArrayList;

import java.util.TreeSet;
import java.util.SortedSet;

public class SortedSetTest {
	public static void main(String[] args) {
		
		// Defining the set as Generic of type INT only
		SortedSet<Integer> ss = new TreeSet<Integer>();
		
		// Adding elements in any order
		ss.add(45);
		ss.add(98);
		ss.add(1);
		ss.add(-91);
		ss.add(651);
		ss.add(59);
		ss.add(72);
		ss.add(67);
		ss.add(-9);
		
		System.out.println("Sorted Set is: "+ss);
		
		System.out.println("\nFirst element is: "+ss.first());
		
		System.out.println("\nLast element is: "+ss.last());
		
		System.out.println("\nElements less than 98 are: "+ss.headSet(98));
		
		System.out.println("\nElement greater than equal to 45 are: "+ss.tailSet(45));
		
		// For reverse sorted set, the 'To' field should be less than 'From' field
		System.out.println("\nElements from 45 to 98 are: "+ss.subSet(45, 98));
		
		// In sorted set the insertion order is lost -> Since we get a sorted order
		
	}
}
