package vehicleShop.models.worker;

public class FirstShift extends BaseWorker {
    private static final int INITIAL_STRENGTH = 100;
//    private static final int STRENGTH_CONSUMPTION = 10;

    public FirstShift(String name) {
        super(name, INITIAL_STRENGTH);
    }

//    @Override
//    public void working() {
//        this.setStrength(this.getStrength() -STRENGTH_CONSUMPTION);
//        if (this.getStrength() < 0) {
//            this.setStrength(0);
//        }
//    }
}
