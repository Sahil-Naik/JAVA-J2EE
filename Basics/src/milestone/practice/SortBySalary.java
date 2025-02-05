package milestone.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortBySalary {
	public static void main(String[] args) {
		List<Integer> employeeSalary = Arrays.asList(10000,
				25000,
				13500,
				14500,
				25750,
				16500,
				13250);
		
		List<Integer> sortedEmployeeSalary = employeeSalary.stream().sorted((a , b) -> b - a).collect(Collectors.toList());
		
		System.out.println("Sorted Salary (Descending): " + sortedEmployeeSalary);
		
	}

}
