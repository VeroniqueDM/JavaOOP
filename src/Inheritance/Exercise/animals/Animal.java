package Inheritance.Exercise.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.age = age;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.gender = gender;
        }
    }

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName() + " ").append(this.getAge() + " ").append(this.getGender()).append(System.lineSeparator());
        sb.append(this.produceSound());
        return String.valueOf(sb);
    }

    protected abstract String  produceSound();
}
