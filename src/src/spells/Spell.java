package src.spells;

import java.util.Scanner;

public abstract class Spell {
    private static String name;
    private static int creditRequirement;
    private static String description;
    private static int cooldownRounds;
    private static int currentCooldown;
    private static int baseDamage;
    private static double damageMultiplier;
    private static Spell selectedSpell;

    public Spell(String name, int creditRequirement, String description, int cooldownRounds, int baseDamage, double damageMultiplier){
        Spell.name = name;
        Spell.creditRequirement = creditRequirement;
        Spell.description = description;
        Spell.cooldownRounds = cooldownRounds;
        Spell.currentCooldown = 0; // Initially no cooldown
        Spell.baseDamage = baseDamage;
        Spell.damageMultiplier = damageMultiplier;
    }
    public static String getName() {
        return name;
    }
    public static int getCreditRequirement() {
        return creditRequirement;
    }

    public static String getDescription() {
        return description;
    }

    public static int getCooldownRounds() {
        return cooldownRounds;
    }
    public static int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        Spell.currentCooldown = currentCooldown;
    }
    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }
    public int calculateDamage(){
        return(int) (baseDamage * damageMultiplier);
    }
    public static void cast(){
        // get input from the player
        int userChoice = getUserChoice();
    }

    // letting the player choose the spell
    public static int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 3) { // Adjust the range as needed
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
            }
        }
        return choice;
    }
}
