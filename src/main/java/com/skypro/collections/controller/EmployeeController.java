package com.skypro.collections.controller;

import com.skypro.collections.employee.Employee;
import com.skypro.collections.service.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, @RequestParam int salary) {
        return service.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, int salary) {
        return service.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department, int salary) {
        return service.findEmployee(firstName, lastName, department, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
