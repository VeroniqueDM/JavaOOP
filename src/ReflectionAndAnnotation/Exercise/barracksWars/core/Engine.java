package ReflectionAndAnnotation.Exercise.barracksWars.core;

import ReflectionAndAnnotation.Exercise.barracksWars.core.commands.Add;
import ReflectionAndAnnotation.Exercise.barracksWars.core.commands.Command;
import ReflectionAndAnnotation.Exercise.barracksWars.core.commands.Fight;
import ReflectionAndAnnotation.Exercise.barracksWars.core.commands.Report;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {
	private static String COMMANDS_PATH = "ReflectionAndAnnotation.Exercise.barracksWars.core.commands.";
	private static String EXECUTE_METHOD_NAME = "execute";
	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName)  {
		String result = "";
		try {
			String commandClassName = commandName.substring(0,1).toUpperCase()+commandName.substring(1);
			Class clazz = Class.forName(COMMANDS_PATH+commandClassName);
			Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class,Repository.class,UnitFactory.class);
			Command commandInstance = constructor.newInstance(data,this.repository,this.unitFactory);
			Method executeMethod = clazz.getDeclaredMethod(EXECUTE_METHOD_NAME);
			result = (String) executeMethod.invoke(commandInstance);


		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
				 InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
//		switch (commandName) {
//			case "add":
//				Add addCommand = new Add(data,this.repository, this.unitFactory);
//				result = addCommand.execute();
//				break;
//			case "report":
//				Report reportCommand = new Report(data,this.repository, this.unitFactory);
//				result = reportCommand.execute();
//				break;
//			case "fight":
//				Fight fightCommand = new Fight(data,this.repository, this.unitFactory);
//				result = fightCommand.execute();
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;


//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}
//
//	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException {
//		String unitType = data[1];
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//		this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}
//
//	private String fightCommand(String[] data) {
//		return "fight";
//	}
}
