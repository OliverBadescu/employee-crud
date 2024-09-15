package mycode.employee.app.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mycode.employee.app.dto.CreateEmployeeRequest;
import mycode.employee.app.dto.CreateEmployeeResponse;
import mycode.employee.app.dto.UpdateEmployeeRequest;
import mycode.employee.app.service.CommandService;
import mycode.employee.app.service.QueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@AllArgsConstructor
@RequestMapping(("/employees"))
public class EmployeeController {

    private QueryService queryService;
    private CommandService commandService;

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<CreateEmployeeResponse> getEmployee(@PathVariable int employeeId){
        return new ResponseEntity<>(queryService.findById(employeeId),HttpStatus.OK);
    }

    @GetMapping
    public String getEmployees(@RequestParam(value = "page", defaultValue = "1")int page, @RequestParam(value = "limit", defaultValue = "50")int limit){
        return "get employees was called with page= "+ page + " limit:" + limit;
    }


    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> addEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest){

        return new ResponseEntity<>(commandService.addEmployee(createEmployeeRequest),HttpStatus.OK);

    }


    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<CreateEmployeeResponse> updateEmployee(@PathVariable int employeeId,@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest){

        commandService.updateEmployee(employeeId, updateEmployeeRequest);
        CreateEmployeeResponse createEmployeeResponse = queryService.findById(employeeId);
        return new ResponseEntity<>(createEmployeeResponse, HttpStatus.OK);

    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId){

        commandService.deleteEmployee(employeeId);

        return ResponseEntity.noContent().build();

    }

}
