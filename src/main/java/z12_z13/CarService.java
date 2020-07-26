package z12_z13;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;
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
    public void getAllCars(List<Car> cars){
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
    public List<Car> getCarsWithV12Engine(){
        return cars.stream().filter(car -> car.getEngineType() == EngineType.V12).collect(Collectors.toList());
    }
    public List<Car> getCarsProducedBefore1999(){
        return cars.stream().filter(car -> car.getYear() < 1999).collect(Collectors.toList());
    }
    public Car getMostExpensiveCar(){   // domyślnie od min - max
        return cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).collect(Collectors.toList()).get(0);
    }
    public Car getCheapestCar(){
        return cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList()).get(0);
    }
    public List<Car> getCarsWithAtLeast3Manufacturers(){
        return cars.stream().filter(car -> car.getManuracturers().size() >= 3).collect(Collectors.toList());
    }
    public List<Car> getCarsOrderBy(boolean asc){
        if(asc){
            return cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());
        }
        return cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).collect(Collectors.toList());
    }
    public Optional<Car> findCarByBrandAndModel(String brand, String model){
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand) && car.getModel().equals(model))
                .findFirst();
    }
    public List<Car> getCarsProducedByManufacturerName(String name){
        return cars.stream()
                .filter(car -> car.getManuracturers()
                        .stream().anyMatch(manufacturer -> manufacturer.getName().equals(name)))
                .collect(Collectors.toList());
    }
    public List<Car> getCarsProducedByManufacturerYear(int year){
        return cars.stream()
                .filter(car -> car.getManuracturers()
                        .stream().anyMatch(manufacturer -> manufacturer.getYear() == year))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        CarService carService = new CarService();
        carService.removeCarByIndex(0);
        carService.removeCarByIndex(6);
        carService.addCar(new Car("Toyota", "RAV4", 200_000, 2020,
                new ArrayList<>( Arrays.asList(new Manufacturer("Toyota", 2020, "JAP"))),
                EngineType.V8));
        carService.getAllCars(carService.cars);
        System.out.println("AUTA Z SILNIKIEM V12");
        carService.getAllCars(carService.getCarsWithV12Engine());
        System.out.println("AUTA WYPRODUKOWANE PRZED 1999");
        carService.getAllCars(carService.getCarsProducedBefore1999());
        System.out.println("AUTA NAJ");
        carService.getAllCars(new ArrayList<>(Arrays.asList(carService.getMostExpensiveCar())));
        carService.getAllCars(new ArrayList<>(Arrays.asList(carService.getCheapestCar())));
    }





}
