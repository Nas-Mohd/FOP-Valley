/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.fop;

import javax.swing.JFrame;

/**
 *
 * @author ikmal
 */
public class Main {

    public static void main(String[] args) {
        JFrame main = new JFrame();

        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//STOP THE PROGRAM WHEN EXIT
        main.setResizable(true);//Screnn can resize
        main.setTitle("Chillcoder RPG!!!!");

        ProjectFoP game = new ProjectFoP();
        main.add(game);
        main.pack(); //CAUSES FRAME TO FIT THE PREFERED SIZE
        main.setLocationRelativeTo(null); //Screen in the middle
        main.setVisible(true);

        game.thread();
    }

}
