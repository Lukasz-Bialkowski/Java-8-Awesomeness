package entity;

import java.util.List;

public class Company {

    String name;
    Person director;
    List<Building> buildings;
    List<Employee> employees;

    @Override
    public String toString() {
        return "entity.Company{" +
                "name='" + name + '\'' +
                ", director=" + director +
                ", buildings=" + buildings +
                ", tietoEmployees=" + employees +
                '}';
    }

    public Company(String name, Person director, List<Building> buildings, List<Employee> employees) {
        this.name = name;
        this.director = director;
        this.buildings = buildings;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
