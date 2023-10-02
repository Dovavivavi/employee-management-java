package com.company.employee.controller.DAO;

import com.company.employee.controller.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    // todo more methods
    // db > repo > service > serviceimpl > controller > app

    // have to rename entity from last_name > lastName
    //public List<Employees> findAllByOrderByLastNameAsc();

    @Query(value = "SELECT * FROM Employees ORDER BY last_name ASC;", nativeQuery = true)
    public List<Employees> findAllByCustomQuery();
}
