package service;

import DAO.EmployeeDAO;
import lombok.AllArgsConstructor;
import model.Employee;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public int experience(Employee employee) {
        return LocalDate.now().getYear() - employee.getDateOfEmployment().getYear();
    }

    public List<Employee> findEmployeeByExperience(int experience) {
        return employeeDAO.getEmployees().stream()
                .filter(e -> experience(e) == experience)
                .toList();
    }

    public List<Employee> findEmployeeByName(String name) {
        return employeeDAO.getEmployees().stream()
                .filter(x -> x.getName().equals(name))
                .toList();
    }

    public List<Employee> findEmployeeById(int id) {
        return employeeDAO.getEmployees().stream()
                .filter(e -> e.getId() == id)
                .toList();
    }

    public void createEmployee(int id, String name, String poneNumber, LocalDate dateOfEmployment) {
        Employee employee = new Employee(id, name, poneNumber, dateOfEmployment);
        employeeDAO.addEmployee(employee);
    }
}

