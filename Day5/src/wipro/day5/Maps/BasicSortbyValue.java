package wipro.day5.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BasicSortbyValue {
    
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        
        map.put(1, "Elden Ring");
        map.put(2, "Sekiro");
        map.put(3, "Dark Souls 3");
        map.put(4, "Bloodborne");
        
        System.out.println("Our Map is: "+map);
        
        // Convert map entries to a list
        List<Map.Entry<Integer, String>> list = new ArrayList<>(map.entrySet());
        
        System.out.println("\nOur list looks like this: "+list+"\n");
        
        // Sort the list by values
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        
        // Create a new LinkedHashMap to preserve the order of sorted entries
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        sortedMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}