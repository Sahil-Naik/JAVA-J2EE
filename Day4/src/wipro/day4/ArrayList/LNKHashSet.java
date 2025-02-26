package wipro.day4.ArrayList;
import java.util.LinkedHashSet;


public class LNKHashSet {
	
	public static void main(String[] args) {
		LinkedHashSet lhs = new LinkedHashSet();
		
		lhs.add(150);
		lhs.add(null);
		lhs.add(149);
		lhs.add("TEST");
		lhs.add(150);
		
		System.out.println("Linked Hash Set is: "+lhs);
		System.out.println("Size is: "+lhs.size());
		System.out.println("Removing: "+lhs.remove(null));
		System.out.println("Final Linked Hash Set is: "+lhs+", Size: "+lhs.size());
	}

}
