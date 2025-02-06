package wipro.day13.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wipro.day13.main.*;

@Configuration
public class AppConfig {
	
	@Bean(value = "employee")
	public Employee SetEmployee(Address address){
		Employee ep = new Employee();
		ep.setEmployeeID(5001);
		ep.setEmployeeName("Broke");
		ep.setEmployeeDepartment("TEST");
		ep.setEmployeeSalary(25000);
		ep.setAddress(address);
		ep.setSkills(Arrays.asList("Cpp/C", "R", "C#"));
		
		return ep;
	}
	
	@Bean
	public Address SetAddress() {
		Address add = new Address();
		add.setCityName("Mumbai");
		add.setStateName("Maharashtra");
		add.setPincode("411001");
		
		return add;
	}

}
