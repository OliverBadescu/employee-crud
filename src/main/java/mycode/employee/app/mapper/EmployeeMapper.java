package mycode.employee.app.mapper;

import mycode.employee.app.dto.CreateEmployeeResponse;
import mycode.employee.app.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    Employee toEmployee(CreateEmployeeResponse dto);

    CreateEmployeeResponse toDto(Employee employee);


}
