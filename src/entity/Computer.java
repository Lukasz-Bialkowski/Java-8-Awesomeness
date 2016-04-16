package entity;

public class Computer {
    String name;
    Double price;

    public Computer() {
        this("PC", 999.99);
    }

    public Computer(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "entity.Computer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
