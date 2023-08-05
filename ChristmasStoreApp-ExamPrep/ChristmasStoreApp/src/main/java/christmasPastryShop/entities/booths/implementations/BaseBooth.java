package christmasPastryShop.entities.booths.implementations;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.*;

public class BaseBooth implements Booth {

    private  Collection<Delicacy> delicacyOrders;
    private  Collection<Cocktail> cocktailOrders;
    private  int boothNumber;// –the booth number
    private  int capacity;// –  the booth capacity.
    // It can’t be less than zero. In these cases, throw an IllegalArgumentException with the message "Capacity has to be greater than 0!"
    private  int numberOfPeople;// the count of people who want a booth.
    //Cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
    private  double pricePerPerson;// the price per person for the booth.
    private  boolean isReserved;//  returns true if the booth is reserved, otherwise false.
    private  double price;// calculates the price for all people.

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        this.pricePerPerson = pricePerPerson;
        this.setCapacity(capacity);

        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.isReserved=false;
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    public void setCapacity(int capacity) {
        if (capacity<=0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople<0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        } else if (numberOfPeople==0 && !this.isReserved) {
            this.numberOfPeople = numberOfPeople;
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public double getPrice() {
        return this.pricePerPerson*this.numberOfPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.setNumberOfPeople(numberOfPeople);


    }

    @Override
    public double getBill() {
        return this.getPrice() +
                this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum() +
                this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
    }

    @Override
    public void clear() {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.isReserved = false;
        this.setNumberOfPeople(0);
    }
}
