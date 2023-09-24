package com.company.employee.controller.Service;

import com.company.employee.controller.Entity.Employees;

import java.util.List;

public interface EmployeeService {
    Employees findById(int idToFind);
}
