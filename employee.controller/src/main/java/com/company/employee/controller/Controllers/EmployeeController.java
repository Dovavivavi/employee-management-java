package com.company.employee.controller.Controllers;

import com.company.employee.controller.Entity.Employees;
import com.company.employee.controller.Service.EmployeeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theService) {
        employeeService = theService;
    }


    @GetMapping("/list")
    public String employeesListAll(Model employeeModel) {

        List<Employees> employeesToList = employeeService.findAll();

        employeeModel.addAttribute("employees", employeesToList);

        return "employees/employees-list";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model employeeModel) {
        Employees employee = new Employees();

        employeeModel.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employees employeeSavedToDb) {
        employeeService.save(employeeSavedToDb);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int deleteEmployeeId) {
        employeeService.deleteById(deleteEmployeeId);
        return "redirect:/employees/list";
    }

    @GetMapping("/tables")
    public String showTables() {
        employeeService.tables();
        return "";
    }
}
