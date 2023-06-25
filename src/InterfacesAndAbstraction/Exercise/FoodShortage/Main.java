package InterfacesAndAbstraction.Exercise.FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Buyer> buyerHashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length==4) {
                Buyer citizen = new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2],tokens[3]);
                buyerHashMap.putIfAbsent(tokens[0],citizen);
            } else if (tokens.length==3){
                Buyer rebel = new Rebel(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
                buyerHashMap.putIfAbsent(tokens[0],rebel);
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (buyerHashMap.containsKey(input)){
                buyerHashMap.get(input).buyFood();
            }
            input=scanner.nextLine();
        }
//        int totalFood= 0;
//        for (Map.Entry<String, Buyer> buyer : buyerHashMap.entrySet()) {
//            totalFood += buyer.getValue().getFood();
//        }
        int totalFood = buyerHashMap.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
