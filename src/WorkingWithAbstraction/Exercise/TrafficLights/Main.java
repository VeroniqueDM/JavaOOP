package WorkingWithAbstraction.Exercise.TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] colors = scanner.nextLine().split("\\s+");
        List<Light> lights = Arrays.stream(colors).map(light -> new Light(Color.valueOf(light))).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (Light light : lights) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }

    }
}
