package z12_z13;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Car {
    private String brand;
    private String model;
    private double price;
    private int year;
    private List<Manufacturer> manuracturers;
    private EngineType engineType;
}
