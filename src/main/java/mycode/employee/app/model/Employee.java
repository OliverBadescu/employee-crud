package mycode.employee.app.model;


import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Table(name = "employee")
@Entity(name = "Employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "employee_sequence"
    )

    @Column(
            name = "id"
    )

    private int id;


    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String fullName;


    @Column(
            name = "gender",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String gender;


    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INT"
    )
    private int age;

    @Column(
            name = "salary",
            nullable = false,
            columnDefinition = "DOUBLE"
    )
    private double salary;



}
