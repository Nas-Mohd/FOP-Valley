/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import gui.prototype.GUIPrototype;
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
    GUIPrototype game;
    public static boolean hasSpawned, isDead;
    

    
    public int x = 775;
    public int y = 775;
    
    public Goblin(GUIPrototype e) {
        game = e;
        goblinImage();      
        ascii = Print.getAsciiArt("goblin_ascii.txt");
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
    public void draw(Graphics g) {
        BufferedImage image = null;
        image = img;
        g.drawImage(image, x, y, game.map.tilesize, game.map.tilesize, null);
    }
    
}
