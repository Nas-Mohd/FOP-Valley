package src.spells;

public class AiSpells {

    static class CyberneticSpellcraft extends Spell {
        public CyberneticSpellcraft() {
            super("Cybernetic Spellcraft",5, "Constructs a dynamic arcane barrier to block attacks.", 4,5,1.5);
        }

        public static void cast() {
            System.out.println("Casting Cybernetic Spellcraft!");
        }
    }
    static class CircuitEnchantment extends Spell {
        public CircuitEnchantment() {
            super("Circuit Enchantment",15, "Engulfs enemy in an electrical surge, disrupting their abilities momentarily.", 5,5,2);
        }

        public static void cast() {
            System.out.println("Casting Circuit Enchantment!");
        }
    }

    static class QuantumDivination extends Spell {
        public QuantumDivination() {
            super("Quantum Divination",30, "Foresees and counters incoming attacks with precision.", 6,5,2.5);
        }


        public static void cast() {
            System.out.println("Casting Quantum Divination!");
        }
    }


    public static Spell castAiSpells() {
        System.out.println("Choose a spell to cast:");
        System.out.println("1. Cybernetic Spellcraft");
        System.out.println("2. Circuit Enchantment");
        System.out.println("3. Quantum Divination");

        //casting a spell
        int spellChoice = Spell.getUserChoice();
        Spell selectedSpell = null;
        switch (spellChoice) {
            case 1:
                selectedSpell = new CyberneticSpellcraft();
                break;
            case 2:
                selectedSpell = new CircuitEnchantment();
                break;
            case 3:
                selectedSpell = new QuantumDivination();
                break;
            default:
                System.out.println("Invalid spell choice.");
                break;
        }
        return selectedSpell;
    }
}