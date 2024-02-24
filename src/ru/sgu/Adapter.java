package ru.sgu;

// Интерфейс
interface Target {
    void request();
}

// Класс, который мы хотим адаптировать
class Adaptee {
    public void specificRequest() {
        System.out.println("Вызван метод specificRequest() у класса Adaptee");
    }
}

// Адаптер
class Adapter implements Target {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}