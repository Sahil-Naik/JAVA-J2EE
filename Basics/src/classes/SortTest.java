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
        int n = digitList.size();
        // Outer loop
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (digitList.get(j) > digitList.get(j + 1)) {  // Correct comparison
                    // Swap arr[j] and arr[j + 1]
                    int temp = digitList.get(j);
                    swaps++;
                    digitList.set(j, digitList.get(j + 1));
                    digitList.set(j + 1, temp);
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
