package vehicleShop.models.tool;

import static vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool{
    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }
      @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        int currentPower = getPower();
        int decreasedPower = currentPower - 5;
        if (decreasedPower < 0) {
            decreasedPower = 0;
        }
        this.setPower(decreasedPower);
    }
    public void setPower(int power) {
        if (power<0) {
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public boolean isUnfit() {
        return this.getPower()>0;
    }
}
