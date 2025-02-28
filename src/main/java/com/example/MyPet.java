package com.example;

public class MyPet {
    private String name;
    private String species;
    private int hunger;
    private int happiness;
    private int energy;

    public MyPet(String name, String species, int hunger, int happiness, int energy) {
        this.name = name;
        this.species = species;
        this.hunger = hunger;
        this.happiness = happiness;
        this.energy = energy;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void feed() {
        hunger = Math.max(0, hunger - 10);
        energy = Math.max(0, energy - 5);
    }

    public void play() {
        happiness = Math.min(100, happiness + 15);
        hunger = Math.min(100, hunger + 10);
        energy = Math.max(0, energy - 10); 
    }

    public void rest() {
        energy = Math.min(100, energy + 20);
        hunger = Math.min(100, hunger + 5);
    }

    public String getStatus() {
        String status = "Happiness is " + happiness + " hunger level is " + hunger + " and the enrgy level is " + energy + ".";
        return status;
    }

    public void randomEvent() {
        int event = (int) (Math.random() * 3);
        switch (event) {
            case 0:
                System.out.println("Your pet found a toy and is happier!");
                happiness = Math.min(100, happiness + 10);
                break;
            case 1:
                System.out.println("Your pet tripped and lost some energy...");
                energy = Math.max(0, energy - 10);
                break;
            case 2:
                System.out.println("Your pet discovered some food!");
                hunger = Math.max(0, hunger - 15);
                break;
        }
    }


    @Override
    public String toString() {
        return "Pet Name: " + name + "\n" +
                "Species: " + species + "\n" +
                "Happiness: " + happiness + "\n" +
                "Hunger: " + hunger + "\n" +
                "Energy: " + energy;
    }
}
