package src.main.java.com.company.leave.model;

public class Employee {
    private String id;
    private String name;
    private String department;
    private String password;
    private String role;

    public Employee(String id, String name, String department, String password, String role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.password = password;
        this.role = role;
    }

    // Getters (no setters for simplicity)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
