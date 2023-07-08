package DesignPatterns.Lab.Factory;

import java.util.Scanner;

public class CakeFactory {
    public static Cake createCake() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Cake cake =null;
        switch (input) {
            case "carrot":
                cake = new Cake(25,18.2,18);
                cake.prepare();
                cake.bake();
                cake.box();
                break;
            case "fruits":
                cake = new Cake(18,22.2,20);
                cake.prepare();
                cake.bake();
                cake.box();
                break;
        }
        return cake;
    }
}
