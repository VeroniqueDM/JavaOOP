package ReflectionAndAnnotation.Lab.GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class reflectionClass = Reflection.class;
        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
        declaredMethods = Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);

        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();

            if (name.contains("get")) {
                System.out.println(String.format("%s will return class %s", name, declaredMethod.getReturnType().getName()));
            }
        }

        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();

            if (name.contains("set")) {

                System.out.print(String.format("%s and will set field of class ", name));
                Parameter[] parameterTypes = declaredMethod.getParameters();

                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getType().getName() + " ");
                }
                System.out.println();
            }
        }
    }
}
