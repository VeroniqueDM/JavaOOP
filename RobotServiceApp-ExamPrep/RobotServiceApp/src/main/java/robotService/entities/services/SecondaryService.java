package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

public class SecondaryService extends BaseService{
    private static final int CUSTOM_CAPACITY = 15;
    public SecondaryService(String name ) {
        super(name, CUSTOM_CAPACITY);
    }


}
