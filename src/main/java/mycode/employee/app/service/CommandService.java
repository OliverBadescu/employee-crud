package mycode.employee.app.service;

import mycode.employee.app.dto.CreateEmployeeRequest;
import mycode.employee.app.dto.CreateEmployeeResponse;
import mycode.employee.app.dto.UpdateEmployeeRequest;

public interface CommandService {

    CreateEmployeeResponse addEmployee(CreateEmployeeRequest createEmployeeRequest);

    void updateEmployee(int id, UpdateEmployeeRequest updateEmployeeRequest);

    void deleteEmployee(int id);

}
