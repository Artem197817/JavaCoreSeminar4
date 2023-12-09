package DAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class EmployeeDAO {

    private final List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


}
