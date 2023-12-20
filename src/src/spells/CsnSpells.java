package src.spells;

public class CsnSpells {

    static class CascadeCharm extends Spell {
        public CascadeCharm() {
            super("Cascade Charm",5, "Enchants the target with a cascading charm, temporarily reducing their combat effectiveness.", 4,5,1.5);
        }

        public static void cast() {
            System.out.println("Casting Cascade Charm!");
        }
    }
    static class EtherwebShield extends Spell {
        public EtherwebShield() {
            super("Etherweb Shield",15, "Creates an impenetrable ether web shield, blocking incoming damage.", 5,10,2);
        }

        public static void cast() {
            System.out.println("Casting Etherweb Shield!");
        }
    }

    static class FirewallEnchantment extends Spell {
        public FirewallEnchantment() {
            super("Firewall Enchantment",30, "Manifests a roaring firewall, causing solid damage to the target.", 6,15,2);
        }


        public static void cast() {
            System.out.println("Casting Firewall Enchantment!");
        }
    }


    public static Spell castCsnSpells() {
        System.out.println("Choose a spell to cast:");
        System.out.println("1. Cascade charm");
        System.out.println("2. Etherweb Shield");
        System.out.println("3. Firewall Enchantment");

        //casting a spell
        int spellChoice = Spell.getUserChoice();
        Spell selectedSpell = null;
        switch (spellChoice) {
            case 1:
                selectedSpell = new CascadeCharm();
                break;
            case 2:
                selectedSpell = new EtherwebShield();
                break;
            case 3:
                selectedSpell = new FirewallEnchantment();
                break;
            default:
                System.out.println("Invalid spell choice.");
                break;
        }
            return selectedSpell;
    }
}
