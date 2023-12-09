import DAO.EmployeeDAO;
import controller.EmployeeController;
import service.EmployeeService;
import view.Input;
import view.Output;

import java.time.LocalDate;

/**
 * Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
 * - каждый сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService(new EmployeeDAO());
        EmployeeController employeeController = new EmployeeController(new Input()
                , employeeService
                , new Output());
        employeeController.createEmployee();
        employeeService.createEmployee(5, "Bob", "15654315", LocalDate.of(2005, 12, 5));
        employeeService.createEmployee(1, "Tom", "25655165", LocalDate.of(2002, 1, 13));
        employeeService.createEmployee(4, "Anna", "84813522", LocalDate.of(2017, 2, 25));
        employeeService.createEmployee(7, "Jack", "84861611", LocalDate.of(2016, 6, 12));
        employeeService.createEmployee(8, "Kate", "65165156", LocalDate.of(2015, 8, 8));
        employeeController.findEmployeeById();
        employeeController.findEmployeeByExperience();
        employeeController.findPoneNumberByName();
    }
}
