package ReflectionAndAnnotation.Lab;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflectionClass = Reflection.class;
        // PART 3
//        Field[] fields = reflectionClass.getFields();
//        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
//                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));
//        Method[] methods = reflectionClass.getDeclaredMethods();
//        Arrays.stream(methods)
//                .filter(method -> method.getName().startsWith("get") && method.getParameterCount()==0 && Modifier.isPrivate(method.getModifiers()))
//                .forEach(method -> System.out.printf("%s have to be public!%n",method.getName()));
//        Arrays.stream(methods)
//                .filter(method -> method.getName().startsWith("set") && method.getParameterCount()==1 && !Modifier.isPrivate(method.getModifiers()))
//                .forEach(method -> System.out.printf("%s have to be private!%n",method.getName()));

        // Access Modifiers
//        Method method = reflectionClass.getDeclaredMethod("getName");
//        System.out.println(method.getModifiers()); // 17
//        int modifiers = method.getModifiers();
//        boolean isPublic = Modifier.isPublic(modifiers);
//        boolean isProtected = Modifier.isProtected(modifiers);
//        boolean isAbstract = Modifier.isAbstract(modifiers);


        // PART 2
        Method[] methods = reflectionClass.getDeclaredMethods();
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount()==0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s%n",method.getName(),method.getReturnType().getSimpleName()));
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set")|| method.getParameterCount()==1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
                        method.getName(),method.getParameterTypes()[0].getSimpleName()));



        // PART 1
//        System.out.println(reflectionClass);
//        System.out.println(reflectionClass.getSuperclass());
//        Class[] interfaces = reflectionClass.getInterfaces();
//        for (Class anInterface : interfaces) {
//            System.out.println(anInterface);
//        }
//        Object reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();
//        System.out.println(reflectionObject);

//        System.out.println(reflectionClass.getName());
//        System.out.println(reflectionClass.getSimpleName());
    }
}
