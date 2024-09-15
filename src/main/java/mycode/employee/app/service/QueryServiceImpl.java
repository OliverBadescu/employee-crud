package mycode.employee.app.service;

import lombok.AllArgsConstructor;
import mycode.employee.app.dto.CreateEmployeeResponse;
import mycode.employee.app.exceptions.NoEmployeeFound;
import mycode.employee.app.mapper.EmployeeMapper;
import mycode.employee.app.model.Employee;
import mycode.employee.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QueryServiceImpl implements QueryService{

    private EmployeeRepository employeeRepository;

    @Override
    public CreateEmployeeResponse findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            return new CreateEmployeeResponse(employee.get().getId(),employee.get().getFullName(),employee.get().getAge(),employee.get().getGender(),employee.get().getSalary());
        }else{
            throw new NoEmployeeFound(" ");
        }

    }
}
