package ru.sgu;

class CombustionCar extends Car implements Vehicle {
    private final String brand;

    public CombustionCar(String brand, String fuelType) {
        super("Легковой автомобиль на ДВС", fuelType);
        this.brand = brand;
    }

    @Override
    String getBrand() {
        return brand;
    }

    @Override
    public void start() {
        System.out.println("Заводим двигатель автомобиля " + getBrand() + " на топливе " + fuelType);
    }

    @Override
    public void shutdown() {
        System.out.println("Выключаем двигатель автомобиля " + getBrand());
    }

    @Override
    public void refuel() {
        System.out.println("Заправляем автомобиль " + getBrand() + " топливом " + fuelType);
    }
}


class ElectricCar extends Car implements Vehicle {
    private final String brand;

    public ElectricCar(String brand) {
        super("Электрокар", "электричество");
        this.brand = brand;
    }

    @Override
    String getBrand() {
        return brand;
    }

    @Override
    public void start() {
        System.out.println("Заводим электромотор автомобиля " + getBrand());
    }

    @Override
    public void shutdown() {
        System.out.println("Глушим электромотор автомобиля " + getBrand());
    }

    @Override
    public void refuel() {
        System.out.println("Заряжаем аккумулятор автомобиля " + getBrand());
    }
}


class Truck extends Car implements Vehicle {
    private final String brand;

    public Truck(String brand, String fuelType) {
        super("Грузовой автомобиль", fuelType);
        this.brand = brand;
    }

    @Override
    String getBrand() {
        return brand;
    }

    @Override
    public void start() {
        System.out.println("Заводим грузовик " + getBrand() + " на топливе " + fuelType);
    }

    @Override
    public void shutdown() {
        System.out.println("Глушим грузовик " + getBrand());
    }

    @Override
    public void refuel() {
        System.out.println("Заправляем грузовик " + getBrand() + " топливом " + fuelType);
    }
}

class Motorcycle extends Car implements Vehicle {
    private final String brand;

    public Motorcycle(String brand, String fuelType) {
        super("Мотоцикл", fuelType);
        this.brand = brand;
    }

    String getBrand() {
        return brand;
    }

    @Override
    public void start() {
        System.out.println("Заводим мотоцикл" + getBrand() + " на топливе " + fuelType);
    }

    @Override
    public void shutdown() {
        System.out.println("Глушим мотоцикл " + getBrand());
    }

    @Override
    public void refuel() {
        System.out.println("Заправляем мотоцикл " + getBrand() + " топливом " + fuelType);
    }
}