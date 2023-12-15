/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fop.valley;

/**
 *
 * @author Dummfak
 */
public class Print {
    
    
    public static void combatStartingText() {
        String separator = "+---------------------------------------------+";
        System.out.println("The monster roars ferociously! and also says \"You suck\"");
        System.out.println("You get ready to slay this son of a b*tch");
        System.out.println("");
        System.out.println(separator);
    }
    
    public static void printChoices (Entity e) {
        String separator = "+---------------------------------------------+";
        for (String action : e.actions)
            System.out.println(action);
        System.out.println(separator);
    }
    
    public static void printEffects (char type, Fight aThis, Entity doer) {
        System.out.println("");
        System.out.println("+---------------------------------------------+");
        switch (type){
            case '1':
                System.out.println( doer.name + " has HIT for " + aThis.recentDamageDone + "!");
                break;
        }
                
    }


}
