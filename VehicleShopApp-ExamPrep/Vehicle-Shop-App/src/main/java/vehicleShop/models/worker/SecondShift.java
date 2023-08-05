package vehicleShop.models.worker;

public class SecondShift extends BaseWorker{
    private static final int INITIAL_STRENGTH = 70;
//    private static final int STRENGTH_CONSUMPTION =15 ;

    public SecondShift(String name) {
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
