package vehicleShop.models.worker;

import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

import static vehicleShop.common.ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY;
import static vehicleShop.common.ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseWorker implements Worker {
    private String name;

    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException(WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(int strength) {
        if (strength<0) {
            throw new IllegalArgumentException(WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    private int strength;
    private Collection<Tool> tools;


    public BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    @Override
    public void working() {
        int currentStrength = getStrength(); //текущата сила на рабоника
        int decreasedStrength = currentStrength - 10;
        if (decreasedStrength < 0) {
            decreasedStrength = 0;
        }
        setStrength(decreasedStrength);
    }

    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.getStrength()>0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }
    @Override
    public String toString() {
        long leftTools = this.tools.stream().filter(tool -> tool.getPower() > 0).count();
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + ", Strength: " + strength).append(System.lineSeparator());
        sb.append("Tools: " + leftTools + " fit left").append(System.lineSeparator());
        return sb.toString().trim();
    }
}
