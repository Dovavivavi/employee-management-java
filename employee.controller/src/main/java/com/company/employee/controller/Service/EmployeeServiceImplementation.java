package com.company.employee.controller.Service;

import com.company.employee.controller.DAO.EmployeeRepository;
import com.company.employee.controller.Entity.Employees;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepo) {
        repository = employeeRepo;
    }

    @Override
    public Employees findById(int idToFind) {
        Optional<Employees> result = repository.findById(idToFind);

        Employees foundEmployee = null;

        if(result.isPresent()) {
            foundEmployee = result.get();
        } else {
            throw new RuntimeException("did not found any employee with the id: " + idToFind);
        }

        return foundEmployee;
    }
}
