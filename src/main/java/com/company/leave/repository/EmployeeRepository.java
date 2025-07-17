package src.main.java.com.company.leave.repository;

import java.util.HashMap;
import java.util.Map;

import src.main.java.com.company.leave.model.Employee;

public class EmployeeRepository {
    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeRepository() {
        // Sample data
        employees.put("e101", new Employee("e101", "John Requester", "Sales", "123", "requester"));
        employees.put("e202", new Employee("e202", "Mary Manager", "HR", "123", "manager"));
        // Add others as needed
    }

    public Employee findById(String id) {
        return employees.get(id);
    }

    public Employee authenticate(String id, String password) {
        Employee e = findById(id);
        return (e != null && e.getPassword().equals(password)) ? e : null;
    }
}
