package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private VehicleRepository vehicleRepository;
    private WorkerRepository workerRepository;

    private int countMadeVehicle;

    public ControllerImpl() {
        this.vehicleRepository = new VehicleRepository();
        this.workerRepository = new WorkerRepository();

        this.countMadeVehicle = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {
        if (type.equals("FirstShift")) {
            this.workerRepository.add(new FirstShift(workerName));
        } else if (type.equals("SecondShift")) {
            this.workerRepository.add(new SecondShift(workerName));
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }
        return String.format(ADDED_WORKER,type,workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        this.vehicleRepository.add(new VehicleImpl(vehicleName,strengthRequired));

        return String.format(SUCCESSFULLY_ADDED_VEHICLE,vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = this.workerRepository.findByName(workerName);
        if (worker==null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        worker.addTool(new ToolImpl(power));
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER,power,workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> availableWorkers = this.workerRepository.getWorkers().stream().filter(worker -> worker.getStrength()>70).collect(Collectors.toList());
        if (availableWorkers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        Vehicle vehicle = this.vehicleRepository.findByName(vehicleName);
        Shop shop = new ShopImpl(); //магазин -> making

        int brokenTools = 0;
        while (!availableWorkers.isEmpty() && !vehicle.reached()) {
            Worker worker = availableWorkers.get(0);
            shop.make(vehicle, worker);
            brokenTools += worker.getTools().stream().filter(Tool::isUnfit).count();

            if (!worker.canWork() || worker.getTools().stream().noneMatch(t -> !t.isUnfit())) {
                //не може да работи -> или няма сила, или няма инструменти
                availableWorkers.remove(worker);
            }
        }
        //или са свършили работниците, или колата е готова
        if (vehicle.reached()) {
            //готова кола
            countMadeVehicle++;
            return String.format(VEHICLE_DONE, vehicleName, "done")
                    + String.format(COUNT_BROKEN_INSTRUMENTS, brokenTools);
        } else {
            //колата не е завършена
            return String.format(VEHICLE_DONE, vehicleName, "not done")
                    + String.format(COUNT_BROKEN_INSTRUMENTS, brokenTools);
        }

    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vehicles are ready!", countMadeVehicle)).append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());
        workerRepository.getWorkers().forEach(worker -> {
            sb.append(worker.toString()).append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
