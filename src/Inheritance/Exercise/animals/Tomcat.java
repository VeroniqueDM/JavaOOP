package Inheritance.Exercise.animals;

public class Tomcat extends Cat{
    private static final String KITTEN_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, KITTEN_GENDER);

    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
