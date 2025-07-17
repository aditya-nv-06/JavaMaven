package src.main.java.com.company.leave.cli;

import src.main.java.com.company.leave.repository.EmployeeRepository;
import src.main.java.com.company.leave.roles.requester.LeaveRequesterMenu;
import src.main.java.com.company.leave.roles.manager.LeaveManagerMenu;
import src.main.java.com.company.leave.model.Employee;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository employeeRepo = new EmployeeRepository();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Leave Management System");
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Employee employee = employeeRepo.authenticate(id, password);
        if (employee == null) {
            System.out.println("Invalid credentials");
            return;
        }

        System.out.printf("\nWelcome, %s (%s)\n", employee.getName(), employee.getRole());

        switch (employee.getRole()) {
            case "requester":
                new LeaveRequesterMenu(employee.getId()).run();
                break;
            case "manager":
                new LeaveManagerMenu(employee.getId()).run();
                break;
            default:
                System.out.println("Role not yet implemented");
        }
    }
}
