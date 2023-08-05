package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

public class MainService extends BaseService{
    private static final int CUSTOM_CAPACITY = 30;
    public MainService(String name ) {
        super(name, CUSTOM_CAPACITY);
    }

}
