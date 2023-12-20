/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author chris
 */
public class EncounterLogs {

    private ArrayList<String> encounterList;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public EncounterLogs(){
        encounterList = new ArrayList();
        
    }
    
    public void addEncounter(String encounter){
        encounterList.add(encounter);
    }
    
    public ArrayList<String>getEncounterList(){
        return encounterList;
    }
}
