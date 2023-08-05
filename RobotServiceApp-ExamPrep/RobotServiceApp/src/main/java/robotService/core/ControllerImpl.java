package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {

        if (type.equals("SecondaryService")) {
            this.services.add(new SecondaryService(name));

        } else if (type.equals("MainService")) {
            this.services.add(new MainService(name));
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {

        if (type.equals("PlasticArmor")) {
            this.supplements.addSupplement(new PlasticArmor());

        } else if (type.equals("MetalArmor")) {
            this.supplements.addSupplement(new MetalArmor());
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
        if (this.supplements.findFirst(supplementType) != null) {
            service.addSupplement(supplementType.equals("PlasticArmor") ? new PlasticArmor() : new MetalArmor());
            this.supplements.removeSupplement(this.supplements.findFirst(supplementType));
        } else {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }


        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if (robotType.equals("MaleRobot")) {
             robot = new MaleRobot(robotName,robotKind,price);
        } else if (robotType.equals("FemaleRobot")) {
             robot = new FemaleRobot(robotName,robotKind,price);
        }else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().orElse(null);
        if ((service.getClass().getSimpleName().equals("MainService") && robotType.equals("FemaleRobot")) ||
                (service.getClass().getSimpleName().equals("SecondaryService") && robotType.equals("MaleRobot"))) {
            return UNSUITABLE_SERVICE;
        } else {
            service.addRobot(robot);
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE,robotType,serviceName);
        }
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().orElse(null);
        service.feeding();
        return String.format(FEEDING_ROBOT,service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().orElse(null);
        double sumValue = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
        sumValue += service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        return String.format(VALUE_SERVICE,serviceName,sumValue);
    }

    @Override
    public String getStatistics() {
        return this.services.stream().map(Service::getStatistics).collect(Collectors.joining("\n"));

    }
}
