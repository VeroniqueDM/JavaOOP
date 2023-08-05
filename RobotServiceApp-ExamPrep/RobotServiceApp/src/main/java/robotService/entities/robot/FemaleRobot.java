package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
    private static final int GAINING_KILOGRAMS = 1;

    private static final int INITIAL_KILOGRAMS = 7;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        this.setKilograms(super.getKilograms()+GAINING_KILOGRAMS);
    }
}
