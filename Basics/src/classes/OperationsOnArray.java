package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationsOnArray {
	
	public int ArraySum(ArrayList<Integer> arr) {
		int arrayLength = arr.size();
		int arraySum = 0;
		
		for (int i=0; i<arrayLength; i++) {
			arraySum += arr.get(i);
		}
		
		return arraySum;
	}
	
	public float ArrayAverage(ArrayList<Integer> arr) {
		int arrayLength = arr.size();
		int arraySum = ArraySum(arr);
		
		float arrayAvg = (float) arraySum / arrayLength;
		//System.out.println(arrayLength);
		
		return arrayAvg;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> userArray = new ArrayList<>();
		OperationsOnArray OOA = new OperationsOnArray();
		
		int userCount = 0;
		int userNumber = 0;
		int userArraySum = 0;
		float userArrayAverage;
		
		System.out.printf("How many numbers to add: ");
		userCount = scanner.nextInt();
		
		for (int i=0; i<userCount; i++) {
			System.out.printf("Enter element: ");
			userNumber = scanner.nextInt();
			userArray.add(userNumber);
		}
		
		System.out.println("\nArray is: " + userArray);
		
		userArraySum = OOA.ArraySum(userArray);
		System.out.println("\nSum of numbers in array is: " + userArraySum);
		
		userArrayAverage = OOA.ArrayAverage(userArray);
		System.out.printf("\nAverage of numbers in array is: %.2f", userArrayAverage);
		
		scanner.close();
	}
	
	

}
