package InterfacesAndAbstraction.Exercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> birthables= new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]){
                case "Citizen":
                    Birthable citizen = new Citizen(tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4]);
                    birthables.add(citizen);
                    break;
                case "Robot":
                    Identifiable robot = new Robot(tokens[1],tokens[2]);
                    break;
                case "Pet":
                    Birthable pet = new Pet(tokens[1],tokens[2]);
                    birthables.add(pet);
                    break;
            }
            input= scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable birthable : birthables) {
            String currentYear = birthable.getBirthDate().split("/")[2];
            if (currentYear.equals(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
