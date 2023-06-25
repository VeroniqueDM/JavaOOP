package InterfacesAndAbstraction.Exercise.FoodShortage;

public class Citizen implements Person, Identifiable, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

//    @Override
//    public String toString() {
//        return "Citizen{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", id='" + id + '\'' +
//                ", birthDate='" + birthDate + '\'' +
//                '}';
//    }

    @Override
    public String getId() {
        return id;
    }

//    @Override
//    public String getBirthDate() {
//        return birthDate;
//    }

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        this.food +=10;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}