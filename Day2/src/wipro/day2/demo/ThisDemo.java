package wipro.day2.demo;
	
class Student {
	int rollNumber;
	String sName;
	String division;


	Student(int rollNumber, String sName, String division){
		this.rollNumber = rollNumber;
		this.sName = sName;
		this.division = division;
	}

	void display() {
		System.out.println(rollNumber+" - "+sName+" - "+division);
	}

}

public class ThisDemo {
	
	public static void main(String[] args) {
		Student s1 = new Student(101, "TEST", "B");
		Student s2 = new Student(102, "TEST2", "A");
		s1.display();
		s2.display();
	}

}
