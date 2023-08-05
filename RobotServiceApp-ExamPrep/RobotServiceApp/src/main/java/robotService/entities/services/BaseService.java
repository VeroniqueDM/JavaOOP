package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    protected BaseService(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.robots = new ArrayList<>();
        this.supplements = new ArrayList<>();
    }

    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements);
    }

    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(this.robots);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int sumHardness() {
        return this.getSupplements().stream().mapToInt(Supplement::getHardness).sum();
    }

    ;

    public void addRobot(Robot robot) {
        if (this.getRobots().size() >= this.getCapacity()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.robots.add(robot);

    }

    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    ;

    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    ;

    public void feeding() {
        this.robots.forEach(Robot::eating);
    }

    ;

    public String getStatistics() {
//        "{serviceName} {serviceType}:
//        Robots: {robotName1} {robotName2} {robotName3} ... / Robots: none
//        Supplements: {supplementsCount} Hardness: {sumHardness}"
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + " " + this.getClass().getSimpleName()+ ":").append(System.lineSeparator());
        sb.append("Robots: ").append(this.robots.isEmpty() ? "none" : this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" "))).append(System.lineSeparator());
        sb.append("Supplements: ").append(this.supplements.size()).append(" Hardness: ").append(this.sumHardness());
        return sb.toString();
    }

}
