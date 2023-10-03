package com.company.employee.controller.Service;

import com.company.employee.controller.DAO.EmployeeRepository;
import com.company.employee.controller.Entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepo) {
        repository = employeeRepo;
    }

    @Override
    public List<Employees> findAll() {
        return repository.findAllByCustomQuery();
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

    @Override
    public void save(Employees employeeToSave) {
        repository.save(employeeToSave);
    }

    @Override
    public void deleteById(int idToDelete) {
        repository.deleteById(idToDelete);

        //logging out delete
        System.out.println("employee was deleted with the id: " + idToDelete);
    }

    @Override
    public Array tables() {
        Array tables = repository.tables();
        System.out.println(tables);
        return tables;
    }
}
