package Encapsulation.Lab.FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()<3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        } else {
            this.firstName = firstName;

        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        } else {
            this.lastName = lastName;

        }    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=3) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        } else {
            this.age = age;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary<460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        } else {
            this.salary = salary;
        }
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);

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
