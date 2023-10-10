package com.company.employee.controller.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyInterfaceController {
    @GetMapping("/")
    public String renderHome() {
        return "login/home";
    }

    @GetMapping("/managers")
    public String renderManagers() {
        return "login/managers";
    }

    @GetMapping("/admins")
    public String renderAdmins() {
        return "login/admins";
    }
}
