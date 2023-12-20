package src.spells;

public class SeSpells {

    static class DebuggingDivination extends Spell {
        public DebuggingDivination() {
            super("Debugging Divination",5, "Harnesses ethereal energies to deal moderate damage.", 4,5,1.5);
        }

        public static void cast() {
            System.out.println("Casting Debugging Divination!");
        }
    }
    static class AlgorithmicAlchemy extends Spell {
        public AlgorithmicAlchemy() {
            super("Algorithmic Alchemy",15, "Unleashes a complex algorithmic barrier, evading incoming damage.", 5,5,2);
        }

        public static void cast() {
            System.out.println("Casting Algorithmic Alchemy!");
        }
    }

    static class LogicWeave extends Spell {
        public LogicWeave() {
            super("Logic Weave",30, "Creates an intricate logic of magical energy to cause heavy damage.", 6,5,2.5);
        }


        public static void cast() {
            System.out.println("Casting Logic Weave!");
        }
    }


    public static Spell castSeSpells() {
        System.out.println("Choose a spell to cast:");
        System.out.println("1. Debugging Divination");
        System.out.println("2. Algorithmic Alchemy");
        System.out.println("3. Logic Weave");

        //casting a spell
        int spellChoice = Spell.getUserChoice();
        Spell selectedSpell = null;
        switch (spellChoice) {
            case 1:
                selectedSpell = new DebuggingDivination();
                break;
            case 2:
                selectedSpell = new AlgorithmicAlchemy();
                break;
            case 3:
                selectedSpell = new LogicWeave();
                break;
            default:
                System.out.println("Invalid spell choice.");
                break;
        }
        return selectedSpell;
    }
}
