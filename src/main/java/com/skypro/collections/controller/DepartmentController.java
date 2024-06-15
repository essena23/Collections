package com.skypro.collections.controller;

import com.skypro.collections.employee.Employee;
import com.skypro.collections.service.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(path = "/departments")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalary(int departmentId){
        return departmentService.getMinSalary(departmentId);

    }
    @GetMapping (path = "/max-salary")

    public Employee getMaxSalary(int departmentId){
        return departmentService.getMaxSalary(departmentId);

    }
    @GetMapping (path = "/all")

    public List<Employee> getAllEmployeesByDepartment(int departmentId){
        return departmentService.getAllEmployeesByDepartment(departmentId);

    }
    @GetMapping (path = "/all-grouped")

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment(){
        return departmentService.getAllEmployeesGroupedByDepartment();

    }

}
