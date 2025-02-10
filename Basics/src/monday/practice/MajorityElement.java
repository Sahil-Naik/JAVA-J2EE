// Find the majority element (appears more than n/2 times)

package monday.practice;

public class MajorityElement {
	public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        int majorityElement = findMajorityElement(arr);
        
        if (majorityElement != -1) {
            System.out.println("The majority element is: " + majorityElement);
        } else {
            System.out.println("No majority element found.");
        }
    }

    public static int findMajorityElement(int[] arr) {
        int candidate = -1;
        int count = 0;

        // Step 1: Find the candidate for majority element
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // Check if the candidate is indeed the majority element
        if (count > arr.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element found
        }
    }
}
