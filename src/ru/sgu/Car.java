package ru.sgu;

import java.util.Objects;

abstract class Car implements Vehicle, Comparable<Car>, Cloneable {
    abstract String getBrand();

    protected String carType;
    protected String fuelType;

    public Car(String carType, String fuelType) {
        this.carType = carType;
        this.fuelType = fuelType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), fuelType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return Objects.equals(carType, car.carType)
                && Objects.equals(getBrand(), car.getBrand())
                && Objects.equals(fuelType, car.fuelType);
    }

    @Override
    public int compareTo(Car o) {
        return (this.carType + this.getBrand() + this.fuelType).compareTo(o.carType + o.getBrand() + o.fuelType);
    }

    @Override
    public String toString() {
        return "Тип автомобиля: " + this.carType + "\nМарка автомобиля: " + getBrand() + "\nТип топлива: " + this.fuelType;
    }

    // Поверхностная
    public Car shallowCopy() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    // Глубокая копия
    public Car deepCopy() throws CloneNotSupportedException {
        Car cloneCar = (Car) super.clone();
        cloneCar.carType = this.carType;
        cloneCar.fuelType = this.fuelType;
        return cloneCar;
    }
}
