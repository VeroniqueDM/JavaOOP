package InterfacesAndAbstraction.Exercise.Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {
            sb.append((url.chars().anyMatch(Character::isDigit)) ? "Invalid URL!" : String.format("Browsing: %s!", url)).append(System.lineSeparator());
        }
        return String.valueOf(sb).trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            sb.append((number.chars().allMatch(Character::isDigit)) ? String.format("Calling... %s", number) : "Invalid number!").append(System.lineSeparator());
        }
        return String.valueOf(sb).trim();
    }
}
