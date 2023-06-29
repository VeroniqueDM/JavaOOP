package ReflectionAndAnnotation.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		String input = scanner.nextLine();
		Consumer<Field> printerField = field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName());
		while (!input.equals("HARVEST")) {
			if (input.equals("private")) {
				Arrays.stream(fields).filter(field -> Modifier.isPrivate( field.getModifiers()))
						.forEach(printerField::accept);
//						.forEach(field -> System.out.printf("%s %s %s%n","private", field.getType().getSimpleName(),field.getName()));
			} else if (input.equals("protected")) {
				Arrays.stream(fields).filter(field -> Modifier.isProtected( field.getModifiers()))
						.forEach(printerField);
//						.forEach(field -> System.out.printf("%s %s %s%n","protected", field.getType().getSimpleName(),field.getName()));
			} else if (input.equals("public")) {
				Arrays.stream(fields).filter(field -> Modifier.isPublic( field.getModifiers()))
						.forEach(printerField);
//						.forEach(field -> System.out.printf("%s %s %s%n","public", field.getType().getSimpleName(),field.getName()));
			} else if (input.equals("all")) {
				Arrays.stream(fields)
						.forEach(printerField);
//						.forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
			}

			input = scanner.nextLine();
		}

	}
}
