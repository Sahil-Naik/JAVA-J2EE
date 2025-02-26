package wipro.day5.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
 
public class ObjectMapTest {
 
	public static void main(String[] args) {
 
		SortedMap<Float, Game> sm = new TreeMap<>();
 
		Game Elden = new Game(1, "Elden Ring");
		Game DS = new Game(4, "Dark Souls 3");
		Game Bloodborne = new Game(3, "Bloodborne");
		Game Sekiro = new Game(2, "Sekiro");
		Game Overwatch = new Game(5, "Overwatch");
 
		sm.put(139.5f, Elden);
		sm.put(119.7f, Sekiro);
		sm.put(99.0f, DS);
		sm.put(250.0f, Bloodborne);
		sm.put(5.0f, Overwatch);
 
		List<Map.Entry<Float, Game>> list = new ArrayList<>(sm.entrySet());
		
		System.out.println("\nOur list is: " + list + "\n"); 
		
		Collections.sort(list, new GNComparator());
		
		//System.out.println("Our list is: " + list + "\n");
 
		for (Map.Entry<Float, Game> entry : list) {
			System.out.println("$"+entry.getKey() + " \t-> #" + entry.getValue().getgRank()
					+ ". " + entry.getValue().getgName());
		}
 
	}
}
