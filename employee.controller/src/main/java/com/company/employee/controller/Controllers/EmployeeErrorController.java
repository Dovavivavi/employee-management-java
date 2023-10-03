package com.company.employee.controller.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handlesErrors(HttpServletRequest request) {
        // getting the status code
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // sorting the codes
        if(statusCode != null) {
            Integer statusCodeInString = Integer.valueOf(statusCode.toString());

            if(statusCodeInString == HttpStatus.NOT_FOUND.value()) {
                System.out.println();
                return "error/error-404";
            } else if(statusCodeInString == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/error-500";
            }
        }

        return "error";
    }

}
