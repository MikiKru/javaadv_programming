package sesja_samodzielna.s7;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private Integer salary;
    private String name;

    // constructor, getters and setters omitted
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 3000, "John"));
        employees.add(new Employee(2, 15000, "Mark"));
        employees.add(new Employee(3, 40000, "Bill"));
        Employee employee = employees
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 30000)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }
}