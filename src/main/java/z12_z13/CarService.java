package z12_z13;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(
                    "VW", "Passat", 150_000, 2019,
                    new ArrayList<>(Arrays.asList(new Manufacturer("VAG", 2019, "GER"))),
                    EngineType.V8),
            new Car(
                    "Ferrari", "360", 700_000, 2018,
                    new ArrayList<>(Arrays.asList(
                            new Manufacturer("Ferrari", 2018, "ITA"),
                            new Manufacturer("Lamborgini", 2017, "ITA")
                    )),
                    EngineType.V12),
            new Car(
                    "Fiat", "Panda", 30_000, 2016,
                    new ArrayList<>(Arrays.asList(
                            new Manufacturer("Ferrari", 2011, "ITA"),
                            new Manufacturer("Fiat", 2014, "ITA"),
                            new Manufacturer("Renault", 2011, "FRA")
                    )),
                    EngineType.S3),
            new Car("Nissan", "GTR", 550_000, 2020,
                    new ArrayList<>( Arrays.asList(new Manufacturer("Nissan", 2020, "JAP"))),
                    EngineType.V6)
    ));
    // metody
    public void getAllCars(){
        final int[] id = {1};
        cars.forEach(car -> System.out.printf("Id: %-2d Marka: %-15s Model: %-10s Cena: %10.2f zł Rok: %-4d Producenci: %-80s " +
                        "Engine: %-5s\n",
                id[0]++,
                car.getBrand(),car.getModel(), car.getPrice(), car.getYear(),
                car.getManuracturers().stream()
                        .map(manufacturer -> String.format("Nazwa: %s Kraj: %s", // Stream<Manufacturer>
                                manufacturer.getName(),
                                manufacturer.getCountry()))
                        .collect(Collectors.joining(", ")),                  // String
                car.getEngineType()
        ));
    }
    public void removeCarByIndex(int index){
        try {
            cars.remove(index);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Nie ma auta o zadnym indeksie");
        }
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public static void main(String[] args) {
        CarService carService = new CarService();
        carService.removeCarByIndex(0);
        carService.removeCarByIndex(6);
        carService.addCar(new Car("Toyota", "RAV4", 200_000, 2020,
                new ArrayList<>( Arrays.asList(new Manufacturer("Toyota", 2020, "JAP"))),
                EngineType.V8));
        carService.getAllCars();
    }





}
