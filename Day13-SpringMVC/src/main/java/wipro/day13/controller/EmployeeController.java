package wipro.day13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
