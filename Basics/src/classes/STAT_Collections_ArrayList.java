package classes;
import java.util.ArrayList;

public class STAT_Collections_ArrayList {
	
	public static void main(String[] args) {
		ArrayList<String> cars = new ArrayList<>();
		cars.add("BMW");
		cars.add("FERRARI");
		
		
		System.out.println("Before Array contains: "+cars);
		
		cars.remove("FERRARI");
		
		System.out.println("After Array contains: "+cars);
	}

}
