package com.rtracee.spring.mvc_hibernate_aop.controller;

import com.rtracee.spring.mvc_hibernate_aop.dao.EmployeeDao;
import com.rtracee.spring.mvc_hibernate_aop.entity.Employee;
import com.rtracee.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("all-employee")
    public String getAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employee";
    }

    @RequestMapping("employee-info")
    public String viewAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-info";
    }

    @RequestMapping("add-employee")
    public String addEmployee(@ModelAttribute(name = "employee")  Employee emp) {
        employeeService.addEmployee(emp);
        return "redirect:/all-employee";
    }

    @RequestMapping("update-info")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-info";
    }
}
