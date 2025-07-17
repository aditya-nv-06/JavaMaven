package src.main.java.com.company.leave.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import src.main.java.com.company.leave.model.LeaveRequest;
import src.main.java.com.company.leave.repository.LeaveRequestRepository;

public class LeaveRequesterService {
    private final LeaveRequestRepository repository;
    private final String employeeId;

    public LeaveRequesterService(LeaveRequestRepository repository, String employeeId) {
        this.repository = repository;
        this.employeeId = employeeId;
    }

    public void requestLeave() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("End date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Leave type: ");
        String type = scanner.nextLine();

        LeaveRequest request = new LeaveRequest(
            UUID.randomUUID().toString(),
            employeeId,
            startDate,
            endDate,
            type
        );
        repository.save(request);
        System.out.println("Leave request submitted!");
    }

    public void viewStatus() {
        List<LeaveRequest> requests = repository.findByEmployeeId(employeeId);
        for (LeaveRequest r : requests) {
            System.out.printf("%s: %s to %s, %s, status: %s%n",
                r.getId(), r.getStartDate(), r.getEndDate(), r.getType(), r.getStatus());
        }
    }
}
