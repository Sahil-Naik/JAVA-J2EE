package wipro.day5.Maps;

import java.util.Comparator;

public class GameRankComparator implements Comparator<Game> {
 
	@Override
	public int compare(Game o1, Game o2) {
		
		return o2.getgRank().compareTo(o1.getgRank());
		
	}
 
}
