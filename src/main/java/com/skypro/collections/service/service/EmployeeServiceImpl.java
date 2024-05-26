package com.skypro.collections.service.service;

import com.skypro.collections.Exceptions.EmployeeAlreadyExistException;
import com.skypro.collections.Exceptions.EmployeeNotFoundException;
import com.skypro.collections.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl() {
        EmployeeList = new ArrayList<>();
    }

    public final List<Employee> EmployeeList;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (EmployeeList.contains(employee)) {
            throw new EmployeeAlreadyExistException();
        }
        EmployeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (EmployeeList.contains(employee)) {
            EmployeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (EmployeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(EmployeeList);
    }
}
