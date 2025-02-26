package wipro.day5.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "Elden Ring");
		map.put(2, "Sekiro");
		map.put(3, "Dark Souls 3");
		map.put(4, "Bloodborne");
		
		System.out.println("Our Map is: "+map);
		
		System.out.println("\nAt number 3 we have: "+map.get(3));
		
		// Check if a key exists
        if (map.containsKey(4)) {
            System.out.println("\n4 is in the map.");
        }
        
        System.out.println("\nAlternate way of printing:");
        
        // Iterate over the map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
	}

}
