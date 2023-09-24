package com.company.employee.controller.DAO;

import com.company.employee.controller.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    // todo more methods
    // db > repo > service > serviceimpl > controller > app
}
