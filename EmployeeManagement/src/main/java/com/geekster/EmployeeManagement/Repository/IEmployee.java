package com.geekster.EmployeeManagement.Repository;

import com.geekster.EmployeeManagement.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee  extends JpaRepository<Employee, Long> {


}
