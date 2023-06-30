package ReflectionAndAnnotation.Exercise.barracksWars.core.commands;

import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        return this.getRepository().removeUnit(unitType);
//        if (countUnits == null) {
//
//            System.out.println("No such units in repository.");
//        } else {
//            this.amountOfUnits.put(unitType, --countUnits);
//        }
//        return output;
    }
}
