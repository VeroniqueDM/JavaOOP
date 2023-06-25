package InterfacesAndAbstraction.Exercise.CollectionHierarchy;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String word) {
        if (super.getMaxSize()>super.getItems().size()){
            super.getItems().add(word);
            return super.getItems().size()-1;
        }
        return -1;
    }
}
