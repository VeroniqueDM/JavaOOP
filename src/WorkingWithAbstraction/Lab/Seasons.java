package WorkingWithAbstraction.Lab;

public enum Seasons {
    SUMMER ("summer", 32, "low"),
    WINTER ("winter", -2, "high"),
    AUTUMN ("autumn", 20, "medium"),
    SPRING ("spring", 18, "medium");
    private String name;
    private double temperature;
    private String chancesOfRain;

    Seasons(String name, double temperature, String chancesOfRain) {
        this.name = name;
        this.temperature = temperature;
        this.chancesOfRain = chancesOfRain;
    }
}
