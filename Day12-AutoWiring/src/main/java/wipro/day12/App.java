package wipro.day12;

import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee);
	}
 
}
