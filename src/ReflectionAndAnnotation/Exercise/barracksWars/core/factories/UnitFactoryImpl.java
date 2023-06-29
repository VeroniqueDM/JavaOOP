package ReflectionAndAnnotation.Exercise.barracksWars.core.factories;

import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionAndAnnotation.Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3
		try {
			Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = clazz.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
				 IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
