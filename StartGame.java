
package textadventuregame;

import java.util.Scanner;

/*
 * @author Saad_Ahmed_Pathan_22114077
 */
public class StartGame {    

    private static final Scanner scanner = new Scanner(System.in);
    
//    public static void main(String[] args) {
//        StartGame startGame = new StartGame();
//        startGame.start();
//    }

    public void start() {
        // Step 01: Introduction, Instructions, and Player Name
        displayIntroduction();
        displayInstructions();
        String playerName = getPlayerName();

        // Game loop
        while (true) {
            // Step 01: Game Start or Quit
            displayStartOptions(playerName);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Start the game
                    System.out.println("Let the adventure begin!");
                    // Call the method to proceed with the game logic
                    // For simplicity, let's assume a hypothetical method named 'playGame'
                    // playGame(playerName);
                    break;
                case 2:
                    // Quit the game
                    System.out.println("Thank you for playing! Goodbye, " + playerName + "!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        }
    }

    private void displayIntroduction() {
        System.out.println("Welcome to the Epic Adventure Game!");
        System.out.println("Embark on a journey full of challenges and excitement.");
        System.out.println();
    }

    private void displayInstructions() {
        System.out.println("Instructions:");
        System.out.println("1. Read the story carefully.");
        System.out.println("2. Make choices wisely.");
        System.out.println("3. Face challenges and overcome obstacles.");
        System.out.println();
    }

    private String getPlayerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

//    private void displayStartOptions(String playerName) {
//        System.out.println("Hello, " + playerName + "!");
//        System.out.println("Options:");
//        System.out.println("1. Start the game");
//        System.out.println("2. Quit");
//        System.out.print("Enter your choice: ");
//    }
    
    private Archetypes chooseCharacter() {
    System.out.println("Choose your character:");
    System.out.println("1. Warrior");
    System.out.println("2. Paladin");
    System.out.println("3. Rogue");
    System.out.println("4. Archer");
    System.out.println("5. Magician");

    int characterChoice = scanner.nextInt();
    scanner.nextLine();  // Consume the newline character left by nextInt()

    switch (characterChoice) {
        case 1:
            Warrior warrior = new Warrior();
            warrior.displayCharacterInfo();
            
            return warrior;
            
        case 2:
            Paladin paladin = new Paladin();
            paladin.displayCharacterInfo();
            return paladin;
            
        case 3:
            Rogue rogue = new Rogue();
            rogue.displayCharacterInfo();
            return rogue;
            
        case 4:
            Archer archer = new Archer();
            archer.displayCharacterInfo();
            return archer;
            
        case 5:
            Magician magician = new Magician();
            magician.displayCharacterInfo();
            return magician;
            
        default:
            System.out.println("Invalid choice. Defaulting to Warrior.");
            return new Warrior();
    }
}

private void displayStartOptions(String playerName) {
    System.out.println("Hello, " + playerName + "!");
    System.out.println("Options:");
    System.out.println("1. Start the game");
    System.out.println("2. Quit");
    System.out.print("Enter your choice: ");

    int choice = scanner.nextInt();
    scanner.nextLine();  // Consume the newline character left by nextInt()

    switch (choice) {
        case 1:
            Archetypes selectedCharacter = chooseCharacter();
            System.out.println("You selected: " + selectedCharacter.getClass().getSimpleName());
            
            // Continue with the game logic, passing the selected character
            // For simplicity, let's assume a hypothetical method named 'startGame'
            // startGame(selectedCharacter);
            break;
        case 2:
            System.out.println("Thank you for playing! Goodbye, " + playerName + "!");
            System.exit(0);
        default:
            System.out.println("Invalid choice. Please choose 1 or 2.");
    }
}

}
 

