package wipro.day4.multiclass;

import java.util.TreeSet;

public class Test1 {
	
	public static void main(String[] args) {
		TreeSet<Employee> companyRecords = new TreeSet<>();
		
		companyRecords.add(new Employee(145, "Pink", 45000));
		companyRecords.add(new Employee (132, "Mist", 53750));
		companyRecords.add(new Employee(111, "Game", 25778));
		companyRecords.add(new Employee (102, "Neice", 13000));
		companyRecords.add(new Employee(191, "Soul", 67500));
		companyRecords.add(new Employee (152, "Elden", 21000));
		
	    /* 
	     * By default it will return in sorted EmployeeID.
		 * We created this sorting method in Employee Class since TreeSet 
		 * needs this method.
		 * TreeSet does not support  data type, so we created our own 
		 * 'CompareTo' method. 
		 */
		
		System.out.println(companyRecords);
	}

}
