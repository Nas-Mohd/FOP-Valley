<<<<<<< HEAD:javaStuff/FOP-Valley/src/fop/valley/FOPValley.java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fop.valley;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class FOPValley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Entity player = new Entity("Anas");
        Entity monster = new Entity("FOP Slime boy");
<<<<<<< HEAD
        Fight combat = new Fight(player);
        
        
        combat.initiateBattle(monster);
=======
        
        Fight fight = new Fight (player, monster);
        
        fight.initiateBattle(player, monster);
>>>>>>> 1ebd2e3ca212fc6bdb1f7a67fda5bea583ea18c6
    }
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fop.valley;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class FOPValley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
>>>>>>> main:src/fop/valley/FOPValley.java
