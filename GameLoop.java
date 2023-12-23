
package textadventuregame;

import java.util.Random;
import java.util.Scanner;
/*
 * @author Saad_Ahmed_Pathan_22114077
 */
public class GameLoop {
    
    
   
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    
    

    public GameLoop(Archetypes character) {
        
        while (character.getLevel() < 35) {
            int challenge = random.nextInt(4);  // Randomly choose a challenge (0 to 3)

            switch (challenge) {
                case 0:
                    System.out.println("You encounter a challenge in FOP!");
                    break;
                case 1:
                    System.out.println("You encounter a challenge in CM!");
                    break;
                case 2:
                    System.out.println("You encounter a challenge in TAC!");
                    break;
                case 3:
                    System.out.println("You encounter a challenge in CSO!");
                    break;
            }

            // Simulate overcoming the challenge
            simulateChallenge(character);

            // Check if the character leveled up
            if (character.getLevel() >= 35) {
                System.out.println("Congratulations! You've reached the maximum level and won the game!");
                break;
            }

            // Ask the player if they want to continue
            System.out.print("Do you want to continue? (1 for Yes, 2 for No): ");
            int choice = scanner.nextInt();
            if (choice != 1) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
        }
        
    }
    


    GameLoop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void simulateChallenge(Archetypes character) {
        // Simulate the challenge by calling the levelUp method
        character.levelUp();
        // Display character information after leveling up
        character.displayCharacterInfo();
    }

    void startGameLoop(Archetypes warrior) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}


