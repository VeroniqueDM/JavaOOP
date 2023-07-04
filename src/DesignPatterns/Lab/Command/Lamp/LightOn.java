package DesignPatterns.Lab.Command.Lamp;

public class LightOn implements Command {
    private Lamp lamp;

    public LightOn(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.on();
    }
}