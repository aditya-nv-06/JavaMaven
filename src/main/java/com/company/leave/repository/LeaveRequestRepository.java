package src.main.java.com.company.leave.repository;

import src.main.java.com.company.leave.model.LeaveRequest;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class LeaveRequestRepository {
    private final Map<String, LeaveRequest> requests = new HashMap<>();

    public void save(LeaveRequest request) {
        requests.put(request.getId(), request);
    }

    public LeaveRequest findById(String id) {
        return requests.get(id);
    }

    public List<LeaveRequest> findByEmployeeId(String employeeId) {
        List<LeaveRequest> result = new ArrayList<>();
        for (LeaveRequest r : requests.values()) {
            if (r.getEmployeeId().equals(employeeId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<LeaveRequest> findByManagerId(String managerId) {
        List<LeaveRequest> result = new ArrayList<>();
        for (LeaveRequest r : requests.values()) {
            if (r.getManagerId().equals(managerId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<LeaveRequest> findAll() {
        return new ArrayList<>(requests.values());
    }
}
