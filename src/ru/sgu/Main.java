package ru.sgu;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CombustionCar petrolCar = new CombustionCar("Mercedes-Benz SLR McLaren", "бензин");
        ElectricCar electricCar = new ElectricCar("Tesla Model S Plaid");
        Truck truck = new Truck("KAMAZ-54901-70014-CA", "дизель");
        Motorcycle motorcycle = new Motorcycle("Honda СBR650R", "бензин");

        List<Car> cars = List.of(petrolCar, electricCar, truck, motorcycle);
        for (Car car : cars) {
            System.out.println(car);
            car.start();
            car.refuel();
            car.shutdown();
            System.out.println();
        }

        System.out.println("Хэш грузовика " + truck.hashCode());
        System.out.println("Хэш строк " + Objects.hash("KAMAZ-54901-70014-CA", "дизель"));
        System.out.println("Хэш мотоцикла " + motorcycle.hashCode());
        System.out.println();

        // копии
        CombustionCar originalCar = new CombustionCar("Nissan 350z", "бензин");
        Car shallowCopyCar = originalCar.shallowCopy();
        Car deepCopyCar = originalCar.deepCopy();
        originalCar.setCarType("Грузовой автомобиль");
        originalCar.setFuelType("дизель");
        System.out.println("Оригинальный объект\n" + originalCar + "\n");
        System.out.println("Поверхностная копия\n" + shallowCopyCar + "\n");
        System.out.println("Глубокая копия\n" + deepCopyCar + "\n");

        System.out.println(petrolCar.compareTo(petrolCar.shallowCopy()));
        System.out.println(petrolCar.compareTo(petrolCar.deepCopy()));
        System.out.println(petrolCar.compareTo(electricCar));
        System.out.println(electricCar.equals(electricCar.deepCopy()));
        System.out.println(originalCar.equals(petrolCar));
    }
}