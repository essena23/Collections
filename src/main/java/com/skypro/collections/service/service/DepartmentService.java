package com.skypro.collections.service.service;

import com.skypro.collections.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMinSalary(int department);

    Employee getMaxSalary(int department);

    List<Employee> getAllEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment();
}
