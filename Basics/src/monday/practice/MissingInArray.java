package monday.practice;

import java.util.ArrayList;

public class MissingInArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> rangedArray = new ArrayList<Integer>();
		
		rangedArray.add(1);
		rangedArray.add(2);
		rangedArray.add(3);
		rangedArray.add(5);
		rangedArray.add(6);
		rangedArray.add(9);
		
		int maxNumber = rangedArray.get(rangedArray.size()-1);
		//System.out.println(maxNumber);
		
		System.out.printf("Missing numbers are: ");
		
		for (int i=1; i<=maxNumber; i++) {
			boolean isFound = false;
			for (int x: rangedArray) {
				if (x==i) {
					isFound = true;
					break;
				}
			}
			if (!isFound) {  
                System.out.print(i + " ");  
            }  
		}
	}

}
