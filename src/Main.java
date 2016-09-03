import entity.Building;
import entity.Company;
import entity.Employee;
import entity.Person;
import enumeration.CompanyPosition;
import enumeration.PersonSex;
import services.CurrencyFormatter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    Building[] tietoBuildings = {
            new Building("Poczekajka", "20A", "MILENIUM IV"),
            new Building("Strzegom", "52BA", "GREEN ALLEY"),
            new Building("Lotnicza", "101", "EAST GATE"),
            new Building("Zaporowska", "2C", "SKYTOWER")
    };

    Employee[] tietoEmployees = {
            new Employee("Patryk", "Rekas", "2183928", 23, PersonSex.MALE, CompanyPosition.PROJECT_MANAGER, 5231.32),
            new Employee("Danuta", "Stenka", "2183928", 43, PersonSex.FEMALE, CompanyPosition.ANALYTIC, 2231.32),
            new Employee("Jan", "Walczak", "2183928", 23, PersonSex.MALE, CompanyPosition.ANALYTIC, 3231.32),
            new Employee("Grzegorz", "Grzesiak", "2183928", 63, PersonSex.MALE, CompanyPosition.PROGRAMMER, 2991.32),
            new Employee("Dariusz", "Zawada", "2183928", 73, PersonSex.MALE, CompanyPosition.PROGRAMMER, 4431.32),
            new Employee("Alicja", "Szewc", "2183928", 34, PersonSex.FEMALE, CompanyPosition.SQL_DEVELOPER, 1231.32),
            new Employee("Patrycja", "Kalinowska", "2183928", 53, PersonSex.FEMALE, CompanyPosition.SQL_DEVELOPER, 2331.32),
            new Employee("Aleksandra", "Pawlowska", "2183928", 25, PersonSex.FEMALE, CompanyPosition.DESIGNER, 1931.32),
            new Employee("Anna", "Purc", "2183928", 52, PersonSex.FEMALE, CompanyPosition.DESIGNER, 2231.32),
    };

    Building[] nokiaBuildings = {
            new Building("Długolecka", "20A", "MILENIUM IV"),
            new Building("Opolska", "52BA", "HUGE SPACE"),
            new Building("Latawcowa", "101", "SILLICON VALLEY"),
            new Building("Grzegorza", "2C", "BEN HILL")
    };

    Employee[] nokiaEmployees = {
            new Employee("Patryk", "Rekas", "2183928", 23, PersonSex.MALE, CompanyPosition.PROJECT_MANAGER, 10031.32),
            new Employee("Danuta", "Stenka", "2183928", 43, PersonSex.FEMALE, CompanyPosition.ANALYTIC, 2231.32),
            new Employee("Alicja", "Szewc", "2183928", 34, PersonSex.FEMALE, CompanyPosition.SQL_DEVELOPER, 1231.32),
            new Employee("Patrycja", "Kalinowska", "2183928", 53, PersonSex.FEMALE, CompanyPosition.SQL_DEVELOPER, 2331.32),
            new Employee("Aleksandra", "Pawlowska", "2183928", 25, PersonSex.FEMALE, CompanyPosition.DESIGNER, 1931.32),
            new Employee("Anna", "Purc", "2183928", 52, PersonSex.FEMALE, CompanyPosition.DESIGNER, 2231.32),
    };

    Company[] companies = {
            new Company("TIETO", tietoEmployees[0], Arrays.asList(tietoBuildings), Arrays.asList(tietoEmployees)),
            new Company("NOKIA", nokiaEmployees[0], Arrays.asList(nokiaBuildings), Arrays.asList(nokiaEmployees))
    };

    public Main() {

        Employee[] tietoEmployees = this.tietoEmployees;
        Building[] tietoBuildings = this.tietoBuildings;
        Company[] companies = this.companies;

        // Uzupełnienie miejsc pracy
        Stream.of(tietoEmployees).
                forEach(em -> em.setWorkingPlace(tietoBuildings[(int) (Math.random() * tietoBuildings.length)]));

        // Uzupełnienie przełożonych
        Stream.of(tietoEmployees)
                .forEach(em -> em.setBoss(Optional.of(tietoEmployees[0])));

        // Project manager nie ma szefa
        tietoEmployees[0].setBoss(Optional.empty());
    }

    public void showEarningsInTieto() {
        // Zarobki Project managerow
        double bossSalary = Stream.of(tietoEmployees)
                .filter(e -> !e.getBoss().isPresent())
                .mapToDouble(boss -> boss.getSalary())
                .sum();
        System.out.println("Tieto Project manager's salary: " + CurrencyFormatter.format(bossSalary));

        // Zarobki calego zespołu
        double teamSalary = Stream.of(tietoEmployees)
                .filter(e -> e.getBoss().isPresent())
                .mapToDouble(e -> e.getSalary())
                .sum();
        System.out.println("Tieto Team's salary: " + CurrencyFormatter.format(teamSalary));
    }

    public void showTietoFemaleWorkersSortedBySalary() {
        System.out.println("> TIETO FEMALE EMPLOYEES SORTED BY SALARY");
        // Filtruje kobiecosc z wszystkich pracownikow i sortuje według zarobków
        Predicate<Employee> femalePredicate = e -> e.getSex() == PersonSex.FEMALE;

        List<Employee> femaleEmployees = Stream.of(tietoEmployees)
                .filter(femalePredicate)
                .collect(Collectors.toList());

        Collections
                .sort(femaleEmployees, (Employee a, Employee b) -> Employee.compareBySalary(a, b));

        femaleEmployees.stream()
                .forEach(e -> System.out.println(e.getName() + " " + e.getSurname() + ", Sex: " + e.getSex() + ", Salary: " + e.getSalary()));

        double femaleSummary = Stream.of(tietoEmployees)
                .filter(femalePredicate)
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.println("Total: " + CurrencyFormatter.format(femaleSummary)+ " $");

    }

    public void showTietoMaleWorkersSortedByAge() {
        System.out.println("> TIETO MALE WORKERS SORTED BY AGE! ");
        // Filtruje męskość z wszystkich pracownikow i sorkuje według wieku
        Predicate<Employee> malePredicate = e -> e.getSex() == PersonSex.MALE;
        // zmienna Comparator
        Comparator<Person> ageComparator = (a, b) -> Person.compareByAge(a, b);
        Stream.of(tietoEmployees)
                .filter(malePredicate)
                .sorted(ageComparator)
                .forEach(e -> System.out.println(e.getName() + " " + e.getSurname() + ", Sex: " + e.getSex() + ", Age: " + e.getAge() + ", Salary: " + e.getSalary()));
        Double maleSummary = Stream.of(tietoEmployees)
                .filter(malePredicate)
                .mapToDouble(e -> e.getSalary())
                .sum();
        System.out.println("Total: " + CurrencyFormatter.format(maleSummary) + " $");
    }

    public void workersWorkingPlaces() {

        System.out.println("> EMPLOYEE AND WORK LOCATION");
        // Wyswietlam miejsce pracy danego pracownika
        Stream.of(tietoEmployees)
                .map(e -> e.getName() + " " + e.getSurname() + ": " + e.getWorkingPlace().getName())
                .forEach(System.out::println);
    }

    public double countAverageSalary(Company company) {
        return company.getEmployees().stream().mapToDouble(e -> e.getSalary()).sum()
                / company.getEmployees().size();
    }

    public void averageSalaryInCompany() {
        System.out.println(">AVERAGE EARNINGS PER EMPLOYEE! ");
        Comparator<Company> companyEarningsPerEmployee =
                (left, right) ->
                        (int) (countAverageSalary(left) - countAverageSalary(right));

        Stream.of(companies)
                .map(company -> company.getName() + ": " +countAverageSalary(company) + " $")
                .forEach(System.out::println);

        Stream.of(companies)
                .max(companyEarningsPerEmployee)
                .ifPresent(e -> System.out.println("Better salary: " + e.getName()));

    }

    public void numberOfWorkersInTietoBuildings() {
        System.out.println(">NUMBER OF WORKERS IN BUILDINGS!");
        companies[0].getBuildings()
                .stream()
                .map(a ->
                        a.getName() + ": " +
                                companies[0]
                                        .getEmployees()
                                        .stream()
                                        .filter(e -> e.getWorkingPlace().getName().equals(a.getName()))
                                        .count())
                .forEach(System.out::println);

        companies[0].getBuildings()
                .stream()
                .max((a, b) ->
                        companies[0]
                                .getEmployees()
                                .stream()
                                .filter(e -> e.getWorkingPlace().getName().equals(a.getName()))
                                .count() <
                                companies[0]
                                        .getEmployees()
                                        .stream()
                                        .filter(e -> e.getWorkingPlace().getName().equals(b.getName()))
                                        .count() ? -1 : 1)
                .ifPresent(e -> System.out.println("Biggest building: " + e.getName()));

    }

    public void showBenefitsIfPresent() {
        System.out.println("TIETO EMPLOYEES WHO HAS A BENEFIT!");
        Stream.of(tietoEmployees)
                .forEach(e -> e.getBenefit()
                        .ifPresent(p -> System.out.println(e.getName() + " " + e.getSurname() + " has: " + p.getType())));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.averageSalaryInCompany();
    }

}
