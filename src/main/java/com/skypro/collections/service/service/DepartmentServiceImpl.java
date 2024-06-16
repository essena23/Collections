package com.skypro.collections.service.service;

import com.skypro.collections.employee.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final Map<String, Employee> employees = new HashMap<>();
    @PostConstruct
    public void init() {
        employees.put("Трындеева", new Employee("Любовь", "Трындеева",5, 65_000));
        employees.put("Окунь", new Employee("Махрипа","Окунь ", 5, 75_000));
        employees.put("Пыж", new Employee("Андрей", "Пыж",1, 85_000));
        employees.put("Скороговоркина", new Employee("Ольга", "Скороговоркина",2, 70_000));
        employees.put("Огнище", new Employee("Марина", "Огнище",4, 74_000));
        employees.put("Писуль", new Employee("Карл", "Писуль",3, 69_000));
        employees.put("Аркашин", new Employee("Яков", "Аркашин", 1, 71_000));
        employees.put("Якубович", new Employee("Дмитрий", "Якубович",4, 66_000));
        employees.put("Лялякишева", new Employee("Светланка", "Лялякишева",2, 83_000));
        employees.put("Мякишева", new Employee("Кристина", "Мякишева",3, 78_000));

    }

    @Override
    public Employee getMinSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getMaxSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
