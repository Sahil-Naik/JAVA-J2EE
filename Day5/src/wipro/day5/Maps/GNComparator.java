package wipro.day5.Maps;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
 
public class GNComparator implements Comparator<Map.Entry<Float, Game>> {
 
	@Override
	public int compare(Entry<Float, Game> o1, Entry<Float, Game> o2) {
		// TODO Auto-generated method stub
		return o1.getValue().getgName().compareTo(o2.getValue().getgName());
	}
 
}
