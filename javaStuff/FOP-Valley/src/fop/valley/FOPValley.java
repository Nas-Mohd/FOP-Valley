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
        Fight combat = new Fight(player);
        
        
        combat.initiateBattle(monster);
    }
    
}
