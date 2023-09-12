package com.geekster.EmployeeManagement.Service;

import com.geekster.EmployeeManagement.Model.Attendance;
import com.geekster.EmployeeManagement.Model.Employee;
import com.geekster.EmployeeManagement.Repository.IAttendance;
import com.geekster.EmployeeManagement.Repository.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final IEmployee employeeRepository;
    @Autowired
    IAttendance attendanceRepository ;
    @Autowired
    public EmployeeService(IEmployee employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }



    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {

        return employeeRepository.findById(employeeId);
    }
    public double calculateSalary(Long employeeId, LocalDate startDate, LocalDate endDate) {


        List<Attendance> attendanceRecords = attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);


        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {

            int totalDaysPresent = attendanceRecords.size();


            double dailySalary = employee.getSalary();


            return totalDaysPresent * dailySalary;
        }
        return -1;
    }
}
