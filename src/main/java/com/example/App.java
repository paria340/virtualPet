package com.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MyPet myPet = createPet(scanner);
            startGameLoop(scanner, myPet);
        }
    }

    private static MyPet createPet(Scanner scanner) {
        System.out.print("Please enter a name for your pet: ");
        String petName = scanner.nextLine();

        System.out.print("Choose your pet's species: ");
        String petSpecies = scanner.nextLine();

        // Initial hunger, happiness, and energy set to 50 as a starting point
        MyPet myPet = new MyPet(petName, petSpecies, 50, 50, 50);

        System.out.println("Great! You have adopted " + petName + " the " + petSpecies + ".");
        System.out.println("Your pet's initial status is: ");
        System.out.println(myPet);

        return myPet;
    }

    private static void startGameLoop(Scanner scanner, MyPet myPet) {
        boolean running = true;

        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Rest");
            System.out.println("4. Exit");

            int answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    myPet.feed();
                    System.out.println("You fed your pet.");
                    break;
                case 2:
                    myPet.play();
                    System.out.println("You played with your pet.");
                    break;
                case 3:
                    myPet.rest();
                    System.out.println("Your pet took a rest.");
                    break;
                case 4:
                    System.out.println("Thank you for playing! Goodbye.");
                    running = false;
                    continue;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Skip status display for invalid input
            }

            // Display updated pet status
            System.out.println("\nYour pet's current status:");
            System.out.println(myPet);
        }
    }
}
