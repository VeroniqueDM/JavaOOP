package ReflectionAndAnnotation.Exercise.demo;

import java.util.Date;

public class Student {
    private static final String name = null;
    private  double age;

    private Date createdOn;
    private Date lastModifiedOn;


    public Student(String name, double age) {
//        this.name = name;
        this.age = age;
    }

    public Student() {
    }
}
