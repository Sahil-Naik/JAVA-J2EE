package wipro.day5.Maps.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DynamicMapping {
	
	public int ReturnMapSum(Map<String, Integer> funcMap) {
		int total=0;
		
		for (Map.Entry<String, Integer> entry : funcMap.entrySet()) {
            total += entry.getValue();
        }
		return total;
	}
	
	public String ReturnMaxMap(Map<String, Integer> funcMap) {
		int currentMaximum=0;
		String currentKey = "None";
		
		for (Map.Entry<String, Integer> entry : funcMap.entrySet()) {
            if (entry.getValue() > currentMaximum) {
            	currentMaximum = entry.getValue();
            	currentKey = entry.getKey();
            } else {
            	continue;
            }
        }
		return "Value: " + currentMaximum + " - Key: " + currentKey;
	}
	
	public String ReturnMinMap(Map<String, Integer> funcMap) {
		int currentMinimum=Integer.MAX_VALUE;
		String currentKey = "None";
		
		for (Map.Entry<String, Integer> entry : funcMap.entrySet()) {
            if (entry.getValue() < currentMinimum) {
            	currentMinimum = entry.getValue();
            	currentKey = entry.getKey();
            } else {
            	continue;
            }
        }
		return "Value: "+currentMinimum+" - Key: "+currentKey;
	}
	
	
	public static void main(String[] args) {
		
		int userChoice = 0;
		
		DynamicMapping dm = new DynamicMapping();
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> map = new HashMap<>();
		
		do {
			System.out.println("\n1 = Add elements\n2 = View Map\n3 = Total\n4 = Maximum\n5 = Minimum\n6 = Exit");
			System.out.printf("Choose: ");
			
			userChoice = sc.nextInt();
			
			switch (userChoice) {
			case 1: {
				int userCount = 0;
				String key = "None";
				int value = 0;
				
				System.out.printf("\nHow many elements to add: ");
				userCount = sc.nextInt();
				
				for (int i=0; i<userCount; i++) {					
					
					try {
						sc.nextLine();
						
						System.out.printf("Enter Key: ");
						key = sc.nextLine();
						
						System.out.printf("Enter Value: ");
						value = sc.nextInt();
						//sc.nextLine();
						
					} catch (Exception e) {
						System.out.println("Exception: "+e+"\nValues can only be Number!");
						sc.nextLine();
					}
					
					map.put(key, value);
				}
				break;
			}
			
			case 2: {
				System.out.println("\nCurrent Map is: "+map);
				break;
			}
			
			case 3: {
				System.out.println("\nTotal is: " + dm.ReturnMapSum(map));
				break;
			}
			
			case 4: {
				System.out.println("\nMaximum is: \n" + dm.ReturnMaxMap(map));
				break;
			}
			
			case 5: {
				System.out.println("\nMinimum is:\n" + dm.ReturnMinMap(map));
				break;
			}
			
			case 6: {
				System.out.println("\nExiting...");
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + userChoice);
			}
			
			
		} while (userChoice!=6);
		sc.close();
	}

}
