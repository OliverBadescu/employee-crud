package mycode.employee.app.service;

import mycode.employee.app.dto.CreateEmployeeResponse;

public interface QueryService {

    CreateEmployeeResponse findById(int id);

}
