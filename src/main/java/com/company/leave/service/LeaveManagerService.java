package src.main.java.com.company.leave.service;

import src.main.java.com.company.leave.model.LeaveRequest;
import src.main.java.com.company.leave.repository.LeaveRequestRepository;
import java.util.List;
import java.util.Scanner;

public class LeaveManagerService {
    private final LeaveRequestRepository repository;
    private final String managerId;

    public LeaveManagerService(LeaveRequestRepository repository, String managerId) {
        this.repository = repository;
        this.managerId = managerId;
    }

    public void reviewRequests() {
        List<LeaveRequest> pending = repository.findAll()
                .stream()
                .filter(req -> req.getStatus().equals("PENDING"))
                .toList();
        for (LeaveRequest r : pending) {
            System.out.printf("%s: %s to %s, %s%n",
                r.getId(), r.getStartDate(), r.getEndDate(), r.getType());
        }
    }

    public void approveReject() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Request ID: ");
        String reqId = scanner.nextLine();
        LeaveRequest req = repository.findById(reqId);
        if (req == null) {
            System.out.println("Request not found");
            return;
        }
        System.out.print("Approve (Y/N)? ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            req.setStatus("APPROVED");
            req.setManagerId(managerId);
        } else {
            req.setStatus("REJECTED");
        }
        repository.save(req); // Update in HashMap
        System.out.println("Request updated.");
    }
}
