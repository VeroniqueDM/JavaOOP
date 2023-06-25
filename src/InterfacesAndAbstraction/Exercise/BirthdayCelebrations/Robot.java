package InterfacesAndAbstraction.Exercise.BirthdayCelebrations;

public class Robot implements Identifiable {
    private String id;
    private String model;

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }
}
