package wipro.day4.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CompletionException;

public class HashedSet {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();		
		
		hs.add(11);
		hs.add(5);
		hs.add(96);
		hs.add(88);			
		
		// Always initiate Iterator after adding values to HashSet
		Iterator<Integer> i = hs.iterator();
		
		System.out.println("Hashset is: "+hs);
		System.out.println("\nUsing iterator: ");
		
		while (i.hasNext()) {
			System.out.println("Element: "+i.next());
		}
	}
}
