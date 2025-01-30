package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortTest {
	
	public int SortAscending(int x) {
		int swaps = 0;
		
		List<Integer> digitList = new ArrayList<>();

        // Convert the number to a string
        String numberStr = Integer.toString(x);

        // Iterate over the string in reverse order
        for (int i = 0; i <= numberStr.length()-1; i++) {
            // Convert each character to an integer and add to the list
            digitList.add(Character.getNumericValue(numberStr.charAt(i)));
        }
        //System.out.println(digitList);
        
        // Outer loop
        for (int i = 0; i <= digitList.size()-1; i++) {

            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j <= digitList.size()-1; j++) {

                // Checking elements
                int temp = 0, i_ele, j_ele;
                if (digitList.get(j) < digitList.get(i)) {
                	i_ele = digitList.get(i);
                	j_ele = digitList.get(j);
                    // Swapping
                	swaps++;
                    temp = digitList.get(i);
                    i_ele = digitList.get(j);
                    j_ele = temp;
                }
            }
        }        
        return swaps;
	}
	
	public static void main(String[] args) {
		SortTest st = new SortTest();
		Scanner sc = new Scanner(System.in);
		
		int userNumber;
		
		System.out.printf("Enter a Number: ");
		userNumber = sc.nextInt();
		
		System.out.println("Swaps needed: "+st.SortAscending(userNumber));
		
		
		
		sc.close();
	}
	

}
