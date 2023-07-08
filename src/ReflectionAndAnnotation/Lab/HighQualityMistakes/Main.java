package ReflectionAndAnnotation.Lab.HighQualityMistakes;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflection = Reflection.class;

        Field[] fields = reflection.getDeclaredFields();

        Arrays.stream(fields).filter(f -> !Modifier.isPrivate(f.getModifiers())).sorted(Comparator.comparing(Field::getName)).forEach(f -> System.out
                .printf("%s must be private!%n", f.getName()));


        Method[] methods = reflection.getDeclaredMethods();
        Method[] sortedGetters = Arrays.stream(methods).filter(g -> g.getName().startsWith("get") && g.getParameterCount() == 0).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        Arrays.stream(sortedGetters).filter(g -> !Modifier.isPublic(g.getModifiers())).forEach(g -> System.out.printf("%s have to be public!%n", g.getName()));

        Method[] sortedSetters = Arrays.stream(methods).filter(s -> s.getName().startsWith("set") && s.getParameterCount() == 1).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        Arrays.stream(sortedSetters).filter(s -> !Modifier.isPrivate(s.getModifiers())).forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));
    }
}
