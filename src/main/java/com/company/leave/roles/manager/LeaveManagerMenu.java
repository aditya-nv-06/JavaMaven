package src.main.java.com.company.leave.roles.manager;
// something 
import java.util.Scanner;

import src.main.java.com.company.leave.repository.LeaveRequestRepository;

import src.main.java.com.company.leave.service.LeaveManagerService;

public class LeaveManagerMenu {
    private final String employeeId;
    private final LeaveRequestRepository repository;

    public LeaveManagerMenu(String employeeId) {
        this.employeeId = employeeId;
        this.repository = new LeaveRequestRepository();
    }

    public void run() {
        LeaveManagerService service = new LeaveManagerService(repository, employeeId);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTeam Manager Menu");
            System.out.println("1. Review leave requests");
            System.out.println("2. Approve/Reject leave");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: service.reviewRequests(); break;
                case 2: service.approveReject(); break;
                case 3: running = false; break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
