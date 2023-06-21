package Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    public T getRandomElement() {
        Random random = new Random();
        return this.remove(random.nextInt(this.size()));
    }

}
