package mycode.employee.app.service;

import lombok.AllArgsConstructor;
import mycode.employee.app.dto.CreateEmployeeRequest;
import mycode.employee.app.dto.CreateEmployeeResponse;
import mycode.employee.app.dto.UpdateEmployeeRequest;
import mycode.employee.app.exceptions.NoEmployeeFound;
import mycode.employee.app.mapper.EmployeeMapper;
import mycode.employee.app.model.Employee;
import mycode.employee.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandServiceImpl implements CommandService{

    private EmployeeRepository employeeRepository;


    @Override
    public CreateEmployeeResponse addEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = Employee.builder().age(createEmployeeRequest.age()).fullName(createEmployeeRequest.fullName()).gender(createEmployeeRequest.gender()).salary(createEmployeeRequest.salary()).build();

        employeeRepository.saveAndFlush(employee);
        return new CreateEmployeeResponse(employee.getId(),employee.getFullName(),employee.getAge(),employee.getGender(),employee.getSalary());
    }

    @Override
    public void updateEmployee(int id, UpdateEmployeeRequest updateEmployeeRequest) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            employee.get().setAge(updateEmployeeRequest.age());
            employee.get().setFullName(updateEmployeeRequest.fullName());
            employee.get().setGender(updateEmployeeRequest.gender());
            employee.get().setSalary(updateEmployeeRequest.salary());

            employeeRepository.saveAndFlush(employee.get());
        }else{
            throw new NoEmployeeFound("");
        }

    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            employeeRepository.delete(employee.get());
        }else{
            throw new NoEmployeeFound("");
        }
    }
}
