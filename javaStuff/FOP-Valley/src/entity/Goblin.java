/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import gui.prototype.GUIPrototype;
import gui.prototype.Print;
import gui.prototype.ProjectFoP;
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
    ProjectFoP map;
    
    public int goblinX;
    public int goblinY;
    public boolean goblinPositionSet;
    public int randomX;
    public int randomY;
    
    
    public int x = 775;
    public int y = 775;
    
    public Goblin(GUIPrototype e, ProjectFoP map) {
        this.map = map;
        game = e;
        goblinImage();      
        ascii = Print.getAsciiArt("goblin_ascii.txt");
        name = "Ugly Goblin";
        getStats("goblin");
        setGoblinposition();
    
    }
    

    
    public void goblinImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/goblin.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
        
    }
        public void setGoblinposition() {
        if (!goblinPositionSet) {
            // Generate random coordinates for the skeleton's position
             randomX = (int) (Math.random() * map.tilecol); // Random column index
             randomY = (int) (Math.random() * map.tilerow); // Random row index

            // Check if the randomly chosen position is valid (not a solid tile)
            if (map.tilemap[randomX][randomY] != 0) {
                goblinX = map.tilesize * randomX;
                goblinY = map.tilesize * randomY;
                map.tilemap[randomX][randomY] = 2;
                goblinPositionSet = true;
            }
        }
    }
    
    
    public void draw(Graphics g) {
        BufferedImage image = null;
        image = img;
        g.drawImage(image, goblinX, goblinY, game.map.tilesize, game.map.tilesize, null);
    }
    
}

