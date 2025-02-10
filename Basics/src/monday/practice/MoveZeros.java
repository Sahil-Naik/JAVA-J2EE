package monday.practice;

public class MoveZeros {
	
	// Function to print elements of the array
    static void PrintTheArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
	
	public static void main(String[] args) {
		int[] myArr = {1,2,3,0,5,0,7,0};
		
		int countZero = 0; // No need but just in-Case
		
		int[] temp = new int[myArr.length];
		int tempIndex = 0;
		
		for (int i=0; i<myArr.length; i++) {
			if (myArr[i]==0) {
				countZero++;
			} else {
				temp[tempIndex]=myArr[i];
				tempIndex++;
			}
		}
		
		for (int d=tempIndex; d<myArr.length; d++) {
			temp[d] = 0;
		}
		
		PrintTheArray(temp, myArr.length);
	}

}
