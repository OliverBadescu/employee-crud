package mycode.employee.app.dto;

public record CreateEmployeeRequest(String fullName, int age, String gender, double salary) {
}
