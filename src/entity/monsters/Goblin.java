/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.monsters;

import entity.Monster;
import gui.prototype.Game;
import gui.prototype.Print;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Goblin extends Monster{
    
    public static BufferedImage img;
    Game game;
    public static boolean hasSpawned, isDead;
    
    
    public Goblin(Game e) {
        game = e;
        goblinImage();      
        ascii = Print.getAsciiArt("goblin");
        name = "Ugly Goblin";
        getStats("goblin");
        
    
    }
    

    
    public void goblinImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/goblin.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    
    }

    
}
