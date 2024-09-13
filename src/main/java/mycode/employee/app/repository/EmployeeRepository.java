package mycode.employee.app.repository;

import mycode.employee.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



    Optional<Employee> findByFullName(String fullName);

    Optional<Employee> findById(int id);

}
