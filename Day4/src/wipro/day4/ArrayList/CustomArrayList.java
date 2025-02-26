package wipro.day4.ArrayList;

import java.util.Scanner;
import java.util.ArrayList;

public class CustomArrayList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Object>  l = new ArrayList<Object>();
		
		int userChoice = 0;
		
		do {
			System.out.println("1 = Add element\n2 = Delete element\n3 = View List\n4 = Exit");
            System.out.printf("Choose: ");
            userChoice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (userChoice) {
                case 1:
                    System.out.printf("\nEnter element to add: ");
                    String input = sc.nextLine();
                    Object userAdding;

                    // Try to determine the type of input
                    if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                        userAdding = Boolean.parseBoolean(input);
                    } else {
                        try {
                            userAdding = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            userAdding = input; // Treat as String if not an int
                        }
                    }
                    l.add(userAdding);
                    System.out.println("Element added: " + userAdding + "\n");
                    break;

                case 2:
                    System.out.printf("\nEnter element to delete: ");
                    String userDeleting = sc.nextLine();
                    // Attempt to remove the element
                    boolean removed = false;
                    for (Object obj : l) {
                        if (obj.toString().equals(userDeleting)) {
                            l.remove(obj);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        System.out.println("Element removed.\n");
                    } else {
                        System.out.println("Element not found.\n");
                    }
                    break;
				
			case 3:
				System.out.println("\nArray is: " + l + "\n");
				break;
				
			case 4:
				System.out.println("\nExiting...");
				userChoice = 4;
				break;
				
			default:
				System.out.println("Invalid Choice!");
				break;
				
			}
			
		} while (userChoice!=4);
		
		sc.close();
	}
	
}
