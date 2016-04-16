package entity;

import enumeration.PersonSex;

/**
 * Created by luke_bialkowski on 4/16/2016.
 */
public class Person {

    String name;
    String surname;
    String pesel;
    Integer age;
    PersonSex sex;

    public Person(String name, String surname, String pesel, int age, PersonSex sex) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static int compareByAge(Person left, Person right) {
        return left.getAge().compareTo(right.getAge());
    }

    @Override
    public String toString() {
        return "entity.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public PersonSex getSex() {
        return sex;
    }

    public void setSex(PersonSex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
