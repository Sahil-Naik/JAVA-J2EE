package wipro.day12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class App {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee);
	}
 
}
