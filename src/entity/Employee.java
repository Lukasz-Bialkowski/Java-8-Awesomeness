package entity;

import enumeration.BenefitItemType;
import enumeration.CompanyPosition;
import enumeration.PersonSex;

import java.util.Optional;

/**
 * Created by luke_bialkowski on 4/16/2016.
 */
public class Employee extends Person implements Comparable<Employee>{

    Double salary;
    CompanyPosition position;
    Building workingPlace;
    Optional<Employee> boss;

    Optional<BenefitItem> benefit;

    public Optional<BenefitItem> getBenefit() {
        return benefit;
    }

    public void setBenefit(Optional<BenefitItem> benefit) {
        this.benefit = benefit;
    }

    public Building getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(Building workingPlace) {
        this.workingPlace = workingPlace;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public Employee(String name, String surname, String pesel, int age, PersonSex sex, CompanyPosition position, double salary) {
        super(name, surname, pesel, age, sex);
        this.position = position;
        this.salary = salary;
        if(Math.random()>0.5)
            this.benefit = Optional.of(new BenefitItem(BenefitItemType.values()[(int)(Math.random() * BenefitItemType.values().length)]));
        else
            this.benefit = Optional.empty();
    }

    public static int compareBySalary(Employee left, Employee right) {
        return left.getSalary().compareTo(right.getSalary());
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public CompanyPosition getPosition() {
        return position;
    }

    public void setPosition(CompanyPosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "entity.Employee{" +
                "salary=" + salary +
                ", position=" + position +
                ", workingPlace=" + workingPlace +
                ", boss=" + boss + ", " + super.toString() +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    public Optional<Employee> getBoss() {
        return boss;
    }

    public void setBoss(Optional<Employee> boss) {
        this.boss = boss;
    }
}
