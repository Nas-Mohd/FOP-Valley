package src.spells;

public class IsSpells {

    static class DatawaveDivination extends Spell {
        public DatawaveDivination() {
            super("Datawave Divination",5, "Channels data waves to evade attacks.", 4,5,1.5);
        }

        public static void cast() {
            System.out.println("Casting Datawave Divination!");
        }
    }
    static class AnalyticalAlchemy extends Spell {
        public AnalyticalAlchemy() {
            super("Analytical Alchemy",15, "Unleashes a calculated surge, weakening enemy defenses.", 5,5,2);
        }

        public static void cast() {
            System.out.println("Casting Analytical Alchemy!");
        }
    }

    static class PredictionEnchantment extends Spell {
        public PredictionEnchantment() {
            super("Prediction Enchantment",30, "Predicts enemy actions, granting a preemptive advantage.", 6,5,2.5);
        }


        public static void cast() {
            System.out.println("Casting Prediction Enchantment!");
        }
    }


    public static Spell castAiSpells() {
        System.out.println("Choose a spell to cast:");
        System.out.println("1. Datawave Divination");
        System.out.println("2. Analytical Alchemy");
        System.out.println("3. Quantum Divination");

        //casting a spell
        int spellChoice = Spell.getUserChoice();
        Spell selectedSpell = null;
        switch (spellChoice) {
            case 1:
                selectedSpell = new DatawaveDivination();
                break;
            case 2:
                selectedSpell = new AnalyticalAlchemy();
                break;
            case 3:
                selectedSpell = new PredictionEnchantment();
                break;
            default:
                System.out.println("Invalid spell choice.");
                break;
        }
        return selectedSpell;
    }
}