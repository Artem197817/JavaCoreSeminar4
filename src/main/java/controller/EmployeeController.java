package controller;

import lombok.AllArgsConstructor;
import model.Employee;
import service.EmployeeService;
import view.Input;
import view.Output;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class EmployeeController {

    Input input;
    EmployeeService employeeService;
    Output output;

    public void findEmployeeByExperience() {
        int experience = input.inputInt("Стаж сотрудника");
        outputResult(employeeService.findEmployeeByExperience(experience));
    }

    public List<Employee> findEmployeeByName() {
        String name = input.input("Имя сотрудника");
        List<Employee> employees = employeeService.findEmployeeByName(name);
        outputResult(employees);
        return employees;
    }

    public void findEmployeeById() {
        int id = input.inputInt("Id сотрудника");
        outputResult(employeeService.findEmployeeById(id));
    }

    public void createEmployee() {
        int id = input.inputInt("Id сотрудника");
        if (id < 0) {
            outputErrorMessage();
            return;
        }
        String name = input.input("Имя сотрудника");
        String phoneNumber = input.input("Телефон сотрудника");
        output.output("Дата приема на работу");
        int day = input.inputInt("День");
        int month = input.inputInt("Месяц");
        int year = input.inputInt("Год");
        if (year < 1950 || year > LocalDate.now().getYear()) {
            outputErrorMessage();
            return;
        }
        LocalDate dateOfEmployment;
        try {
            dateOfEmployment = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            outputErrorMessage();
            return;
        }
        employeeService.createEmployee(id, name, phoneNumber, dateOfEmployment);
    }

    public void findPoneNumberByName() {
        List<Employee> employees = findEmployeeByName();
        List<String> employeePhoneNumber = new ArrayList<>();
        if (employees != null) {
            for (Employee emp : employees) {
                employeePhoneNumber.add(emp.getName() + " " + emp.getPhoneNumber());
            }
            outputResult(employeePhoneNumber);
        }
    }

    private <E> void outputResult(List<E> list) {
        if (list != null && !list.isEmpty())
            output.outputList(list);
        else
            output.output("Нет сотрудников удовлетворяющих запросу");
    }

    private void outputErrorMessage() {
        output.output("Ошибка ввода. Отмена выполнения операции");
    }
}

