package wipro.day5.Maps.v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SumOfValues {
	
	public int ReturnMapSum(Map<String, Integer> funcMap) {
		int total=0;
		
		for (Map.Entry<String, Integer> entry : funcMap.entrySet()) {
            total += entry.getValue();
        }
		return total;
	}
	
	public static void main(String[] args) {
		
		SumOfValues sov = new SumOfValues();
		
		Map<String,Integer> map = new HashMap<>();
		
		map.put("Class1", 128);
		map.put("Class3", 155);
		map.put("Class2", 121);
		map.put("Class4", 106);
		
		System.out.println("Total is: " + sov.ReturnMapSum(map));
	}

}
