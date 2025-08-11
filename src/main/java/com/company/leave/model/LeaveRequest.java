package src.main.java.com.company.leave.model;

import java.time.LocalDate;


public class LeaveRequest {
    private String id;
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String status; // PENDING, APPROVED, REJECTED, CANCELLED
    private String managerId;
    private String notes;

    public LeaveRequest(String id, String employeeId, LocalDate startDate, LocalDate endDate, String type) {
        this.id = id;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.status = "PENDING";
        this.managerId = "";
        this.notes = "";
    }

    // Getters & Setters
    public String getId() { return id; }
    public String getEmployeeId() { return employeeId; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public String getManagerId() { return managerId; }
    public String getNotes() { return notes; }

    public void setStatus(String status) { this.status = status; }
    public void setManagerId(String managerId) { this.managerId = managerId; }
    public void setNotes(String notes) { this.notes = notes; }
}
