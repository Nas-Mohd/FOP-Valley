package entity.monsters;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
 * @author chris
 */
public class Harpy extends Monster{
    
    public static BufferedImage img;
    public static boolean hasSpawned;
    
    
    public Harpy(Game e, Map f) {
        game = e;
        map = f;
        harpyImage();      
        ascii = Print.getAsciiArt("harpy");
        name = "Smart Harpy";
        getStats("Harpy");
        harpySpawn();
    
    }
    

    
    public void harpyImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/harpy.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    }
    public void harpySpawn(){
        while (!hasSpawned) {
            // Generate random coordinates for the skeleton's position
             Random rd = new Random();
             X = rd.nextInt(40);
             Y = rd.nextInt(40);
            // Check if the randomly chosen position is valid (not a solid tile)
            if (map.tilemap[Y][X] == 1) {
                map.tilemap[Y][X] = 3;
                hasSpawned = true;
            }
        }
    
    }

}
