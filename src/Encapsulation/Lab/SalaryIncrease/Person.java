package Encapsulation.Lab.SalaryIncrease;

//import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
//        DecimalFormat decimalFormat = new DecimalFormat("##.###");
        return String.format("%s %s gets %f leva", this.firstName,this.lastName, this.salary);
    }
    public void increaseSalary(double bonus) {
        if (this.age<30) {
            this.salary += (salary*bonus/100)/2;
        } else {
            this.salary += (salary*bonus/100);
        }
    }
}
