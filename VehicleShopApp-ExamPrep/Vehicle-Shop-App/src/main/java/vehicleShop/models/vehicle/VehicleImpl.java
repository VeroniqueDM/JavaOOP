package vehicleShop.models.vehicle;

import static vehicleShop.common.ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY;
import static vehicleShop.common.ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO;

public class VehicleImpl implements Vehicle {
    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException(VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    @Override
    public int getStrengthRequired() {
        return this.strengthRequired;
    }
    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired<0) {
            throw new IllegalArgumentException(VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.getStrengthRequired()==0;
    }

    @Override
    public void making() {
        int currentNeedStrength = getStrengthRequired();
        currentNeedStrength -= 5;
        if (currentNeedStrength < 0) {
            currentNeedStrength = 0;
        }
        this.setStrengthRequired(currentNeedStrength);
    }
}
