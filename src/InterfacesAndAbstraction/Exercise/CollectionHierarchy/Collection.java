package InterfacesAndAbstraction.Exercise.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection implements Addable{
    private int maxSize = 100;
    private List<String> items;

    public int getMaxSize() {
        return maxSize;
    }

    public List<String> getItems() {
        return items;
    }

    public Collection() {
        this.items = new ArrayList<>();
    }
}
