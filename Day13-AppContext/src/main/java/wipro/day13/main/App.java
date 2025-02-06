package wipro.day13.main;


import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wipro.day13.config.AppConfig;
 
public class App {
	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			Employee employee = (Employee)context.getBean("employee");
			System.out.println(employee);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
