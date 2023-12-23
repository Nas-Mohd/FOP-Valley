
package textadventuregame;
/*
 * @author Saad_Ahmed_Pathan_22114077
 */
public class Archetypes {
    
    // Archetypes class as the base class

    protected int healthPoints;
    protected int magicPoints;
    protected int physicalDefence;
    protected int magicalDefence;
    protected int physicalAttack;
    protected int magicalAttack;
    protected int level;

    public Archetypes(int healthPoints, int magicPoints, int physicalDefence,
                      int magicalDefence, int physicalAttack, int magicalAttack) {
        this.healthPoints = healthPoints;
        this.magicPoints = magicPoints;
        this.physicalDefence = physicalDefence;
        this.magicalDefence = magicalDefence;
        this.physicalAttack = physicalAttack;
        this.magicalAttack = magicalAttack;
        this.level = 1;
    }
    
    public void displayCharacterInfo() {
        System.out.println("Character Information:");
        System.out.println("Health Points: " + healthPoints);
        System.out.println("Magic Points: " + magicPoints);
        System.out.println("Physical Defence: " + physicalDefence);
        System.out.println("Magical Defence: " + magicalDefence);
        System.out.println("Physical Attack: " + physicalAttack);
        System.out.println("Magical Attack: " + magicalAttack);
        System.out.println("Level: " + level);
        
        
    }

    public void levelUp() {
        

    // ... existing code ...

        if (level < 35) {
            level++;

            // Custom leveling-up algorithm based on archetype
            switch (this.getClass().getSimpleName()) {
                case "Warrior":
                    levelUpWarrior();
                    break;
                case "Magician":
                    levelUpMagician();
                    break;
                case "Rogue":
                    levelUpRogue();
                    break;
                case "Paladin":
                    levelUpPaladin();
                    break;
                case "Archer":
                    levelUpArcher();
                    break;
            }

            System.out.println("Level up! New level: " + level);
            displayCharacterInfo();  // Display updated character information
        } else {
            System.out.println("Maximum level reached: " + level);
        }
    }

    // Custom leveling-up algorithm for each archetype
    private void levelUpWarrior() {
        healthPoints += 15;
        physicalDefence += 10;
        magicalDefence += 5;
        physicalAttack += 12;
        magicalAttack += 5;
    }

    private void levelUpMagician() {
        healthPoints += 8;
        magicPoints += 20;
        physicalDefence += 5;
        magicalDefence += 8;
        physicalAttack += 5;
        magicalAttack += 15;
    }

    private void levelUpRogue() {
        healthPoints += 10;
        physicalDefence += 8;
        magicalDefence += 4;
        physicalAttack += 15;
        magicalAttack += 5;
    }

    private void levelUpPaladin() {
        healthPoints += 12;
        magicPoints += 10;
        physicalDefence += 10;
        magicalDefence += 10;
        physicalAttack += 10;
        magicalAttack += 10;
    }

    private void levelUpArcher() {
        healthPoints += 10;
        magicPoints += 5;
        physicalDefence += 8;
        magicalDefence += 5;
        physicalAttack += 18;
        magicalAttack += 5;
    }
    

    
    // ... existing code ...

    public int getLevel() {
        return level;
    }
    

    // ... existing code ...
}



//        if (level < 35) {
//            level++;
//            System.out.println("Level up! New level: " + level);
//        } else {
//            System.out.println("Maximum level reached: " + level);
//        }
//    }
    
    // ... existing code ...



    
    











