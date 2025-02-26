package wipro.day4.ArrayList;

import java.util.TreeSet;
import java.util.SortedSet;
import java.util.Comparator;

public class ReverseSortedSet {
	public static void main(String[] args) {
		
		// Defining the set as Generic of type INT only
		SortedSet<Integer> ss = new TreeSet<Integer>(Comparator.reverseOrder());
		
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
		
		System.out.println("Size of Set is: "+ss.size());
		
		System.out.println("\nFirst element is: "+ss.first());
		
		System.out.println("\nLast element is: "+ss.last());
		
		System.out.println("\nElements less than euqla to 98 are: "+ss.tailSet(98));
		
		System.out.println("\nElement greater than 45 are: "+ss.headSet(45));		
		
		// For reverse sorted set, the 'To' field should be greater than 'From' field
		System.out.println("\nElements from 45 to 98 are: "+ss.subSet(98, 45));
		
		// In sorted set the insertion order is lost -> Since we get a sorted order
		
	}
}
