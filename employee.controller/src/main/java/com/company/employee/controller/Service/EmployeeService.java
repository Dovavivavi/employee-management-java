package com.company.employee.controller.Service;

import com.company.employee.controller.Entity.Employees;

import java.util.List;

public interface EmployeeService {

    List<Employees> findAll();

    Employees findById(int idToFind);

    void save(Employees employeeToSave);

    void deleteById(int idToDelete);

    String tables();
}