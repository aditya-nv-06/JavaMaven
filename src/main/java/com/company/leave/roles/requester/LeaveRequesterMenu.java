package src.main.java.com.company.leave.roles.requester;

import java.util.Scanner;

import src.main.java.com.company.leave.repository.LeaveRequestRepository;
import src.main.java.com.company.leave.service.LeaveRequesterService;

public class LeaveRequesterMenu {
    private final String employeeId;
    private final LeaveRequestRepository repository;

    public LeaveRequesterMenu(String employeeId) {
        this.employeeId = employeeId;
        this.repository = new LeaveRequestRepository();
    }

    public void run() {
        LeaveRequesterService service = new LeaveRequesterService(repository, employeeId);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLeave Requester Menu");
            System.out.println("1. Request leave");
            System.out.println("2. View leave status");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: service.requestLeave(); break;
                case 2: service.viewStatus(); break;
                case 3: running = false; break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
