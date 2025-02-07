package wipro.day14.controller;

import wipro.day14.dao.EmployeeDAO;
import wipro.day14.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addEmployee")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeDAO.addEmployee(employee);
        return "redirect:/viewEmployees";
    }

    @GetMapping("/viewEmployees")
    public String viewEmployees(Model model) {
        List<Employee> employees = employeeDAO.getAllEmployees();
        model.addAttribute("employees", employees);
        return "viewEmployees";
    }
}

