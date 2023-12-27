/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.prototype;

import combat.Combat;
import entity.monsters.Goblin;
import entity.Major;
import entity.Monster;
import entity.Player;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Print {
    static Game window;
    public static String heading;
    public static String mainText;
    public static String textArt;
    static Goblin g;
    static Monster enemy;
    static Major chosenMajor;
    static Player player;
    static String separator = "+----------------------------------------------------+\n";
    static String enter = "<br><br>Hit <b>ENTER</b> to continue";
    
    public static void setWindow(Game e){
        window = e;
    }
    
    public static String getMajors(){
        String majors = "| Artificial Intelligence (<span style='color: lime;'>AI</span>)\n"
                + "| Computer Systems & Network(<span style='color: lime;'>CSN</span>)";
        majors = wrapWithHTML(majors);
        return majors;
    }
    
    public static void setPlayer(entity.Player p) {
        player = p;
    }
    
    public static void showMajors(){
        heading = "Choose Your Major";
        mainText = getMajors();
        textArt = Print.getAsciiArt("book");
        
        printDisplay();       
    }
    
    public static void showHelp(){
        Game.setProgress("Help Screen1");
        heading = "Controls";
        mainText = wrapWithHTML("Text that are <span style='color: green;'>GREEN</span> are used to highlight words you can input in the CLI below.\n"
                + "Text that are <span style='color: red;'>RED</span> are used to highlight either unlockable choices or choices that are on cooldown.\n"
                + "\n\nHit <b>ENTER</b> to go next.\n\n\n\n"
                + "Command Line Interface (CLI)\n<pre'> |\n |\n |\n |\n\\/\n</pre>");
        textArt = getAsciiArt("help");
        
        printDisplay();
    }
    public static void showHelp1(){
        Game.setProgress("Help Screen");
        heading = "Stats/Majors";
        mainText = wrapWithHTML("<span style='color: red;'>ATTACK</span> - determines how much damage your attacks will deal. The HIGHER the attack, the MORE damage dealt.\n"
                + "<span style='color: blue;'>DEFENSE</span> - determines how little damage you will receive. The HIGHER the defense, the LESS damage taken.\n"
                + "<span style='color: yellow;'>CREDITS</span> - determines how much <span style=' color: red;'>ATTACK</span> and <span style=' color: blue;'>Defense</span> you have, basically this game's \"level\". The HIGHER the credits, the MORE attack and defense you have.\n"
                + "<span style='color: green;'>MAJOR</span> - basically this game's \"Classes/Archetypes\". Determines the spells available to the player and how much each stat increases per credit. Ex: AI gets +5 attack per credit vs CSN's +2 attack per credit.\n"
                + "<span style='color: orange;'>SPELLS</span> - are special actions the player can use during combat. After each use, the player must wait before they can use it once more."
                + "\nHit <b>ENTER</b> to go back to menu.");
        textArt = getAsciiArt("help1");
        
        printDisplay();
    }
    
    public static void showMajorsInfo(String s) {

            chosenMajor = new Major(s);
            heading = chosenMajor.name;
            mainText = chosenMajor.desc + "\nType '<span style='color: lime;'>y</span>' to choose this class"
                    + "\nHit <b>ENTER</b> to go back";
            mainText = wrapWithHTML(mainText);
            textArt= chosenMajor.ascii;
                
                
                printDisplay();
        
    }
    
    public static void showStory1(){
        Game.setProgress("Story1");
        heading = "Backstory";
        mainText = "It is November of the year 2027. " + Player.name + " is a " + Player.chosenMajor.name + " final-year student who has just submitted all their requirements. "
                + "You are finally done with the final finals, the last group assignments, your internships and ready to enter the next chapter of your life. "
                +"<br>You look back to all the ups and downs you faced during your uni life. Like the time you overslept and missed one of your exams so they had to beg/bribe the lecturer. "
                + "Or that one time you and your friends went on a roadtrip and had so much fun. You even look back to your first year, where you had to go through the Week Of Welcome."
                + " Waking up 7:00 AM everyday for a week, at the time you just wanted it to end but now you kind of miss it. Oh, and FOP, you are still shocked that you managed to pass that course. <span style='color:blue;'>;-;</span>\n"
                + enter;
        mainText = wrapWithHTML(mainText);
        textArt = getAsciiArt("story1");
        
        printDisplay();
    }
    public static void showStory2(){
        Game.setProgress("Story2");
        mainText = "Your reminiscing came to a stop when you heard your Mom yell \"Go get the car!\" to your Dad. It's your"
                + " convocation today, that's why you're wearing your graduation gown. \"" + Player.name + " let's go now. We do not want to be late for your graduation\", you hear your Mom saying from the other room."
                + " As you leave your room, graduation cap in hand, you feel both nervous and excited for today. <b>BUT THEN</b>, something happened as you pass by the door frame of your room.\n"
                + enter;
        mainText = wrapWithHTML(mainText);
        textArt = getAsciiArt("story2");
        
        printDisplay();
    }
    public static void showStory3(){
        Game.setProgress("Story3");
        mainText = "A portal suddenly appeared in front of you and you get sucked in. For what seemed like an eternity, you fall through a void of nothingness and darkness until you hit solid ground.<br><br>"
                + " You get up and look around, only to find yourself in a different world. A world of fantasy filled with trees as tall as skyscrapers and creatures unlike you have never seen before.\n"
                + enter;
        mainText = wrapWithHTML(mainText);
        textArt = getAsciiArt("story3");
        
        printDisplay();
    }
    public static void showStory4(){
        Game.setProgress("Story4");
        mainText = wrapWithHTML("As the realization that you are no longer on Earth sets in, a cat suddenly magically teleports in front of you. The cat begins speaking to you,"
                + " \"Hi " + Player.name + ". I am <b>Joe Mama</b>, the caretaker of this world. I apologize, it seemed I made a grave mistake and accidentally transported you to this world."
                + " But do not worry, I will transport you as soon as possible. However, while you were travelling from your world to here, your College Credits were 'falling out'. "
                + "<i><s>(Just pretend it makes sense)</s></i> And they were taken by <b>7 monsters</b> of this world. You have to defeat all<b> 7</b> of them and take your Credits back so you can graduate when I send you back\""
                + enter);
        textArt = getAsciiArt("story4");
        
        printDisplay();
    }
    public static void showStory(){
        Game.setProgress("Story");
        mainText = wrapWithHTML("After listening to everything <b>Joe Mama</b> said, <b>Joe Mama</b> suddenly levitated into the sky and disappeared from your view. you ready yourself to explore this world and defeat all <b>7 monsters</b> using the knowledge and skills "
                + Player.chosenMajor.name + " has equipped you with."+enter);
        textArt = getAsciiArt("story");
        
        printDisplay();
    }
    
    public static void printDisplay(){
        window.textArtArea.setText(textArt);
        window.mainTextArea.setText(mainText);
        window.headingLabel.setText(heading);
    }
    
    public static String getAsciiArt( String filename){
        try {
                textArt =  String.join("\n", Files.readAllLines(Paths.get("src/resource/ascii/" + filename + "_ascii.txt" )));
                } catch (IOException e) {
                    textArt = "";
                    System.out.println("Problem with image");
        }
        return Print.ASCIIwrapWithHTML(textArt);
    }
    
    public static void printMonsterEncounter(String monsterName, Monster m){
        enemy = m;
        heading = "You have encountered a " + monsterName;
        //if (monsterName.equals("goblin")){
            mainText = Combat.enemy.getDesc() + "\nType \"<span style='color: lime;'>FIGHT</span>\" to initiate combat \nHit <b>ENTER</b> to go back";
            mainText = wrapWithHTML(mainText);
            textArt = Combat.enemy.getAscii();
            window.textArtArea.setForeground(Color.green);
       // }
        printDisplay();
    }
    
    public static void monsterStartCombat (Monster enemy) {
        System.out.println("monsterStartCombat method invoked. playerhp: " + player.hp);
        System.out.println(Game.progress);
        if (player.hp > 0 && enemy.hp > 0) {
            heading = enemy.getName();
            mainText = getPlayerCombatInfo();
            mainText = wrapWithHTML(mainText);
            printDisplay();
        }

    }
    
    public static String getPlayerCombatInfo() {
        String info;
        
        
        info = "Your Stats: \nHP: " + player.hp + "   " 
                + "Attack: " + player.attack + "   "
                + "Defense: " + player.defense + "   "
                + "Credits: " + player.credits + "\n"+ separator
                + "Basic Moves:\n" + "<span style='color: lime;'>1. Attack</span> - Deal basic damage to your opponent" ;

        if (Combat.defendCD > 0) {
            info += "\n<span style='color: red;'>2. Defend - "+ Combat.defendCD + " / 2 (ON COOLDOWN)</span>";
        }
        else
            info +="\n<span style='color: lime;'>2. Defend</span> - Reduce incoming damage once by increasing your defense (2 cd)";
        if (Combat.healCD > 0)
            info +="\n<span style='color: red;'>3. Heal - "+ Combat.healCD + " / 4 (ON COOLDOWN)</span>";
        else
            info += "\n<span style='color: lime;'>3. Heal</span> - Heal 20% of your Max HP (4 cd)";
        info += "\n<span style='color: lime;'>4. Run</span> - Leave combat (has a chance for failure)\n" + separator 
                + "Spells: ";
        for (int i = 0; i < 3; i++)
            if (player.credits >= Player.chosenMajor.availableSpells[i].credits){
                
                if (Player.chosenMajor.availableSpells[i].countdown > 0) {
                    info += "\n<span style='color: red;'>" + Character.toString('a' + i) + ".) " + Player.chosenMajor.availableSpells[i].name + " - " + Player.chosenMajor.availableSpells[i].countdown + " / " + Player.chosenMajor.availableSpells[i].cd + " (ON COOLDOWN)</span>";
                } else {
                    info += "\n<span style='color: lime;'>" + Character.toString('a' + i) + ".) " + Player.chosenMajor.availableSpells[i].name + "</span>" + " - " + Player.chosenMajor.availableSpells[i].desc + " (" +Player.chosenMajor.availableSpells[i].cd + " cd)";
                }
            } else {
                info += "\n<span style='color: red;'>SPELL LOCKED: " + Player.chosenMajor.availableSpells[i].credits + " credits required to unlock</span>";
            }
        
        return info;
    }
    
    public static void displayEffects (int value) {
        if (Game.progress.equalsIgnoreCase("Attacking")) {
            mainText = "You have HIT the " + enemy.name + " for " + value + " dmg";
            
            System.out.println("ENEMY HP: " + enemy.hp); //TEST CODE
        }
        else if (Game.progress.equalsIgnoreCase("Defending")) {
            mainText = "You ready yourself to take the next hit, increasing your defense by " + value;
            
        }
        else if (Game.progress.equalsIgnoreCase("Healing")) {
            mainText = "You have restored your health by " + value;
            
        }
        else if (Game.progress.equalsIgnoreCase("Running Successful")) {
            mainText = """
                       You raise your fist and start charging towards the monster in front of you. Only to suddenly make a 180 and run as fast as possible.
                       You have ran away SUCCESSFULY. Congratulations, coward...
                       """;
            
        }
        else if (Game.progress.equalsIgnoreCase("Running Failed")) {
            mainText = """
                       You raise your fist and start charging towards the monster in front of you. Only to suddenly make a 180 and run as fast as possible.
                       While running as fast as you can, you trip on your shoelace :[
                       You have FAILED to run away. Better luck next time ;)
                       """;
        }
        else if (Game.progress.equals("Attack Spell")) {
                for (int i = 0; i < 3; i++)
                    if (Player.chosenMajor.availableSpells[i].type.equalsIgnoreCase("attack")){
                        mainText = "You cast " + Player.chosenMajor.availableSpells[i].name + ". Damaging your opponent greatly. You have DEALT " + value + " dmg!";
                        System.out.println("heard attack2");
                    }
                        
                }            
        else if (Game.progress.equals("Status Spell")) {
                for (int i = 0; i < 3; i++)
                    if (Player.chosenMajor.availableSpells[i].type.equalsIgnoreCase("status"))
                        mainText = "You cast " + Player.chosenMajor.availableSpells[i].name + ". You lower your opponent's power and stats!";
                }            
        else if (Game.progress.equals("Defend Spell")) {
                for (int i = 0; i < 3; i++)
                    if (Player.chosenMajor.availableSpells[i].type.equalsIgnoreCase("defend"))
                        mainText = "You cast " + Player.chosenMajor.availableSpells[i].name + ". Which will completely nullify your enemy's next attack!";
                }            
        
        if (Game.progress.equals("Running Successful")){
        } else {
            Game.setProgress("Displaying Effects");
            System.out.println("hi");
        }
        mainText = wrapWithHTML(mainText + enter);

            
        printDisplay();
    }
    
    public static void displayMonsterAction(int value) {
        Random rd = new Random();

        int i = rd.nextInt(4);
        if (enemy.hp < 1)
            mainText = "You have KILLED " + enemy.name;
        else if(Combat.isBlocking){
            mainText = enemy.name + " used their ultimate special killing move, but due to the spell you have casted you took ZERO dmg!";   
            Combat.isBlocking = false;
        }
        else
            mainText = "Monster Stats: \nHP: " + enemy.hp + "   Attack: " + enemy.attack + "   Defense: " + enemy.defense 
            + "   Credits Stolen: " + enemy.credits + "\n" + separator + "\n"
            + enemy.name + enemy.attackDialogues[i] + value + " DMG" 
            + enter;
        mainText = wrapWithHTML(mainText);
        
        Combat.reduceCD();
        printDisplay();
    }
    
    
    public static void gameWin() {
        heading = "YOU WIN!";
        window.headingLabel.setForeground(Color.green);
        window.textArtArea.setForeground(Color.yellow);
        mainText = wrapWithHTML("You have defeated all the monsters and took back all of your college credits !");
        textArt = getAsciiArt("win");
        Game.setProgress("Game Win");
        
        printDisplay();
    }
    
    public static void gameLose() {
        heading = "GAME OVER";
        window.headingLabel.setForeground(Color.red);
        window.textArtArea.setForeground(Color.red);
        mainText = wrapWithHTML("Try again next time!");
        textArt = getAsciiArt("lose");
        Game.setProgress("Game Lose");
        
        printDisplay();
                
    }
    
    
    
    
    
    
    public static String wrapWithHTML(String text) {
        String htmlText = text.replace("\n", "<br>");
         return "<html><style type='text/css'>body { font-family: 'Sylfaen'; font-size: 20pt; color: white; }</style><body>" + htmlText + "</body></html>";
    }
    public static String ASCIIwrapWithHTML(String ASCIIart) {
         return "<html><style type='text/css'>body { font-family: 'Sylfaen'; font-size: 8pt; color: white; }</style><body><pre>" + ASCIIart + "</pre></body></html>";
    }
}
