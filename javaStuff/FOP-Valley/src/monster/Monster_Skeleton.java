
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author chris
 */
public class Monster_Skeleton extends Monster{

    /**
     * @param args the command line arguments
     */
    
     public static void main(String[] args) {
        Monster_Skeleton n = new Monster_Skeleton();
        System.out.println(n.name);
        System.out.println(n.healthPoints);
        System.out.println(n.manaPoints);
        System.out.println(n.Attack);
        System.out.println(n.Defense);
        System.out.println(n.credit);
    }
    public Monster_Skeleton() {
        
        name="Skeleton";
        healthPoints = 60;
        manaPoints=0;
        Attack=12;
        Defense=7;
        credit=65;
        logEncounter("You encounter monster Skeleton!");
        
        try{
    Scanner inputStream = new Scanner(new FileInputStream("C:\\Users\\chris\\Desktop\\Monster.txt.txt"));
    while(inputStream.hasNextLine()){
        String monstername = inputStream.nextLine();
        if(monstername.equalsIgnoreCase(name)){
            healthPoints = inputStream.nextInt();
            manaPoints= inputStream.nextInt();
            Attack= inputStream.nextInt();
            Defense= inputStream.nextInt();
            
        }}
        inputStream.close();
        }catch(FileNotFoundException e){
                System.out.println("File was not found");
                }
    }
    public void logEncounter(String encounter){
        System.out.println(encounter);
    
}
}
