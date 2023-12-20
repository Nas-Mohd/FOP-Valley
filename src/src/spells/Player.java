package src.spells;

public class Player {
    private static int credits;
    private Spell selectedSpell;

    public Player(int initialCredits, Spell selectedSpell) {
        credits = initialCredits;
        this.selectedSpell = selectedSpell;
    }

    public static int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        Player.credits = credits;
    }

    public void castSpell() {

        // Check if the player has enough credits to cast the selected spell
        int playerCredits = getCredits();
        if (selectedSpell == null) throw new AssertionError();

        // Player has enough credits
        if (playerCredits >= Spell.getCreditRequirement()) {
            System.out.println("Casting spell: " + Spell.getDescription());
                // Performing the spell action
                int damageDealt = selectedSpell.calculateDamage();
                System.out.println("Damage created by " + Spell.getName() + ": " + damageDealt);

                // Implementing the cooldown effect
                if (Spell.getCurrentCooldown() == 0) {

                // Set the cooldown for the spell
                int currentCooldown = Spell.getCooldownRounds();
                selectedSpell.setCurrentCooldown(currentCooldown); // Set current cooldown rounds
                System.out.println("Spell cast successfully. Cooldown set to " + currentCooldown + " rounds.");
                selectedSpell.reduceCooldown(); // reduce cooldown rounds
                } else {
                System.out.println("Spell is cooling down! Wait for " + Spell.getCurrentCooldown() + " rounds.");
                selectedSpell.reduceCooldown(); // reduce cooldown rounds
                }
        // Player doesn't have enough credits
        } else {
            System.out.println("You don't have enough credits to cast this spell :(");
        }
    }
}
class CsnPlayer extends Player {
        public CsnPlayer(int initialCredits, Spell selectedSpell) {
            super(initialCredits, selectedSpell);
        }

    public static void main(String[] args) {
        Spell selectedSpell = CsnSpells.castCsnSpells();
        Player csnPlayer = new Player(5, selectedSpell);
        csnPlayer.castSpell();
    }
}
class SePlayer extends Player {
    public SePlayer(int initialCredits, Spell selectedSpell) {
        super(initialCredits, selectedSpell);
    }

    public static void main(String[] args) {
        Spell selectedSpell = SeSpells.castSeSpells();
        Player sePlayer = new Player(getCredits(), selectedSpell);
        sePlayer.castSpell();
    }
}
class AiPlayer extends Player {
    public AiPlayer(int initialCredits, Spell selectedSpell) {
        super(initialCredits, selectedSpell);
    }

    public static void main(String[] args) {
        Spell selectedSpell = AiSpells.castAiSpells();
        Player aiPlayer = new Player(getCredits(), selectedSpell);
        aiPlayer.castSpell();
    }
}
class IsPlayer extends Player {
    public IsPlayer(int initialCredits, Spell selectedSpell) {
        super(initialCredits, selectedSpell);
    }

    public static void main(String[] args) {
        Spell selectedSpell = SeSpells.castSeSpells();
        Player sePlayer = new Player(getCredits(), selectedSpell);
        sePlayer.castSpell();
    }
}
class McPlayer extends Player {
    public McPlayer(int initialCredits, Spell selectedSpell) {
        super(initialCredits, selectedSpell);
    }

    public static void main(String[] args) {
        Spell selectedSpell = SeSpells.castSeSpells();
        Player sePlayer = new Player(getCredits(), selectedSpell);
        sePlayer.castSpell();
    }
}


