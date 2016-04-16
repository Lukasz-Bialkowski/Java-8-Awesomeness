package entity;

public class Building {

    String street;
    String number;
    String name;

    @Override
    public String toString() {
        return "entity.Building{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Building(String street, String number, String name) {
        this.street = street;
        this.number = number;
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
