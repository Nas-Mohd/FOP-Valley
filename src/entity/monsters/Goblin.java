/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.monsters;

import entity.Monster;
import gui.prototype.Game;
import gui.prototype.Map;
import gui.prototype.Print;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Anas Mohammad 23055727
 */
public final class Goblin extends Monster{
    
    public static BufferedImage img;
    public static boolean hasSpawned;
    
    
    public Goblin(Game e, Map f) {
        hasSpawned = false;
        isDead = false;
        game = e;
        map = f;
        id = "goblin";
        goblinImage();      
        ascii = Print.getAsciiArt(id);
        name = "Ugly Goblin";
        getStats("Goblin");
        goblinSpawn();
    
    }
    

    
    public void goblinImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/goblin.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    
    }
    public void goblinSpawn(){
        while (!hasSpawned) {
            // Generate random coordinates for the skeleton's position
             Random rd = new Random();
             X = rd.nextInt(40);
             Y = rd.nextInt(40);
            // Check if the randomly chosen position is valid (not a solid tile)
            if (map.tilemap[Y][X] == 1) {
                map.tilemap[Y][X] = 2;
                hasSpawned = true;
            }
        }
    }

    
}
