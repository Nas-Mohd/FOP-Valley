package monster;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author chris
 */
public class Monster {

    /**
     * @param args the command line arguments
     */
    
        
        public String name;
        public int healthPoints;
        public int manaPoints;
        public int Attack;
        public int Defense;
        public int credit;
        protected EncounterLogs encounterLogs;
    
    
     public Monster(){
     encounterLogs = new EncounterLogs();
        }
}

