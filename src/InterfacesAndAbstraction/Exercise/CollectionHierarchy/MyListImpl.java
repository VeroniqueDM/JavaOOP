package InterfacesAndAbstraction.Exercise.CollectionHierarchy;

public class MyListImpl extends Collection implements MyList{

    @Override
    public String remove() {
        String res = super.getItems().get(super.getItems().size()-1);
        super.getItems().remove(super.getItems().size()-1);
        return res;
    }

    @Override
    public int add(String word) {
        if (super.getMaxSize()>super.getItems().size()){
            super.getItems().add(word);
            return super.getItems().size()-1;
        }
       return -1;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
