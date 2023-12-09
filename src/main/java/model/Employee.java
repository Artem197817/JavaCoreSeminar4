package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String phoneNumber;
    private LocalDate dateOfEmployment;
}
