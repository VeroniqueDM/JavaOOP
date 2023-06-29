package ReflectionAndAnnotation.Exercise.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Class infoClass = Student.class;
        Field field = infoClass.getDeclaredField("name");
        int modifiers = field.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(modifiers));

    }
}
