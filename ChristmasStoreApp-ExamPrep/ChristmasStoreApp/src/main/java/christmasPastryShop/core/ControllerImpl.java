package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.implementations.OpenBooth;
import christmasPastryShop.entities.booths.implementations.PrivateBooth;
import christmasPastryShop.entities.cocktails.implementations.Hibernation;
import christmasPastryShop.entities.cocktails.implementations.MulledWine;
import christmasPastryShop.entities.delicacies.implementations.Gingerbread;
import christmasPastryShop.entities.delicacies.implementations.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;

import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;


public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    public double getTotalIncome() {
        return totalIncome;
    }

    private double totalIncome;
//    public ControllerImpl() {
//        this.boothRepository = new BoothRepositoryImpl();
//        this.cocktailRepository = new CocktailRepositoryImpl();
//        this.delicacyRepository = new DelicacyRepositoryImpl();
//    }

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = this.delicacyRepository.getByName(name);
        if (delicacy!=null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        } else {
            if (type.equals("Gingerbread")) {
                this.delicacyRepository.add(new Gingerbread(name,price));
            } else if (type.equals("Stolen")) {
                this.delicacyRepository.add(new Stolen(name,price));
            }
        }
        return String.format(DELICACY_ADDED,name,type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = this.cocktailRepository.getByName(name);
        if (cocktail!=null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        } else {
            if (type.equals("MulledWine")) {
                this.cocktailRepository.add(new MulledWine(name, size, brand));
            } else if (type.equals("Hibernation")) {
                this.cocktailRepository.add(new Hibernation(name, size, brand));
            }
        }
        return String.format(COCKTAIL_ADDED,name,brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);
        if (booth!=null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST,boothNumber));
        } else {
            if (type.equals("OpenBooth")) {
                this.boothRepository.add(new OpenBooth(boothNumber,capacity));
            } else if (type.equals("PrivateBooth")) {
                this.boothRepository.add(new PrivateBooth(boothNumber,capacity));
            }
        }
        return String.format(BOOTH_ADDED,boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth availableBooth = this.boothRepository.getAll().stream()
                .filter(booth -> !booth.isReserved())
                .filter(booth -> booth.getCapacity()>=numberOfPeople)
                .findFirst().orElse(null);
        if (availableBooth==null) {
            return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
        } else {
            availableBooth.reserve(numberOfPeople);
            return String.format(BOOTH_RESERVED,availableBooth.getBoothNumber(),numberOfPeople);
        }
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth availableBooth = this.boothRepository.getByNumber(boothNumber);
        double bill = availableBooth.getBill();
        this.totalIncome += bill;
        availableBooth.clear();
        return String.format(BILL,
                boothNumber,
               bill);

    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME,this.getTotalIncome());
    }
}
