package wipro.day13.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import wipro.day13.model.Address;
import wipro.day13.model.Employee;

@Controller
public class EmployeeController {

	
	@RequestMapping(method = RequestMethod.GET, value = "/info")
	public ModelAndView info_view() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("info");
		return mv;
	}
	 
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public ModelAndView user_view() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveEmployee")
	public ModelAndView getEmployee(@ModelAttribute Employee employee,
	                                 @RequestParam(value = "skills", required = false) String skills) {

	    ModelAndView mv = new ModelAndView();

	    // Process skills
	    if (skills != null && !skills.isEmpty()) {
	        List<String> skillsList = Arrays.asList(skills.split(","));
	        employee.setSkills(skillsList);
	    }

	    mv.addObject("test", employee);
	    mv.setViewName("info");
	    return mv;
	}
}

// ALTERNATIVE

/*
 * import org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * @Controller public class EmployeeController {
 * 
 * @RequestMapping("/") public String display() { return "index"; }
 * 
 * @RequestMapping("/info") public String info() { return "index"; } }
 */

// URL: http://localhost:8080/SpringMVC/
