package DesignPatterns.Lab.Command.Lamp;

public class LightOff implements Command {
    private Lamp lamp;

    public LightOff(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.off();
    }
}