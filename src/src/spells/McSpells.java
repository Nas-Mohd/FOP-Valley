package src.spells;

public class McSpells {

    static class AudiovisualAlchemy extends Spell {
        public AudiovisualAlchemy() {
            super("Audiovisual Alchemy",5, "Conjures a dazzling array of audio and visual elements, nullifying incoming attacks.", 4,5,1.5);
        }

        public static void cast() {
            System.out.println("Casting Audiovisual Alchemy!");
        }
    }
    static class MultiRealmTransmute extends Spell {
        public MultiRealmTransmute() {
            super("Multi Realm Transmute",15, "Manipulates the fabric of reality, disorienting the enemy.", 5,5,2);
        }

        public static void cast() {
            System.out.println("Casting Multi Realm Transmute!");
        }
    }

    static class SymphonySpellcraft extends Spell {
        public SymphonySpellcraft() {
            super("Symphony Spellcraft",30, "Unleashes a symphony of magical resonance, dealing heavy damage to the target.", 6,5,2.5);
        }


        public static void cast() {
            System.out.println("Casting Symphony Spellcraft!");
        }
    }


    public static Spell castAiSpells() {
        System.out.println("Choose a spell to cast:");
        System.out.println("1. Audiovisual Alchemy");
        System.out.println("2. Multi Realm Transmute");
        System.out.println("3. Symphony Spellcraft");

        //casting a spell
        int spellChoice = Spell.getUserChoice();
        Spell selectedSpell = null;
        switch (spellChoice) {
            case 1:
                selectedSpell = new AudiovisualAlchemy();
                break;
            case 2:
                selectedSpell = new MultiRealmTransmute();
                break;
            case 3:
                selectedSpell = new SymphonySpellcraft();
                break;
            default:
                System.out.println("Invalid spell choice.");
                break;
        }
        return selectedSpell;
    }
}