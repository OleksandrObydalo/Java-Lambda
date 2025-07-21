package lambdas;

public class Employee extends Person {
    protected int id;
    protected int salary;


    public Employee(int id, String firstName, String lastName, int age, int salary) {
        super(firstName, lastName, age);
        this.id = id;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, int age, int salary) {
        super(firstName, lastName, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
