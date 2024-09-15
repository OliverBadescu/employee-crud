package mycode.employee.app.dto;

import jakarta.validation.constraints.NotNull;

public record CreateEmployeeRequest(
        @NotNull(message = "Cannot be null")
        String fullName,
        @NotNull(message = "Cannot be null")
        int age,
        @NotNull(message = "Cannot be null")
        String gender,
        @NotNull(message = "Cannot be null")
        double salary)
{
}
