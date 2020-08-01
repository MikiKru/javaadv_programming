package sesja_samodzielna.s8;

import sesja_samodzielna.s7.Employee;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

public class MainEmployee {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 3000, "John"));
        employees.add(new Employee(2, 15000, "Mark"));
        employees.add(new Employee(3, 40000, "Bill"));
        List<Employee> employeesSorted = employees
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }
}
