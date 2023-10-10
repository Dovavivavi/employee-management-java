package com.company.employee.controller.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyInterfaceLoginController {
    @GetMapping("/loginPage")
    public String renderLogin() {
        return "login/login";
    }
    @GetMapping("/restricted")
    public String renderRestricted() {
        return "login/restricted";
    }
}
