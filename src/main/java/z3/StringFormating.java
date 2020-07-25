package z3;

import java.time.LocalDate;

public class StringFormating {
    public static void main(String[] args) {
        String name = "Adam";
        String lastName = "Kowalski";
        Boolean status = true;
        LocalDate birthDate = LocalDate.of(2000, 2, 5);
        double salary = 7555.2;
        int height = 180;
        // formated string to system.out
        System.out.printf("|%-20s|%20s|%5s|%10s|%10.2f zł|%+5d cm|\n", name, lastName, status, birthDate, salary,height);
        System.out.printf("|%20s|%20s|%5s|%10s|%10.2f zł|%+5d cm|\n", name, lastName, status, birthDate, salary,-180);
        System.out.printf("|%20s|%20s|%5s|%10s|%10.2f zł|%+5d cm|\n", name, lastName, status, birthDate, salary,0);
        System.out.printf("|%20s|%20s|%5s|%10s|%10.2f zł|%5d cm|\n", name, lastName, status, birthDate, salary,height);
        System.out.printf("|%20s|%20s|%5s|%10s|%10.2f zł|%5d cm|\n", name, lastName, status, birthDate, salary,height);
    }
}
