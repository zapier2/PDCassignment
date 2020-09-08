/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdcproject;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gerar
 */
public class Scoreboard {
    private String nameAndScore;
    
    
    public void writeScores(Player p){
        BufferedWriter bw = null;
        
        try{
            
            nameAndScore = p.getPlayerName() +" $"+ p.getWinnings();
          
            bw = new BufferedWriter(new FileWriter("scores.txt"));
            
            bw.append(nameAndScore);
            bw.close();
            
            
        } catch(IOException ex){
            System.out.println("Error while saving scores.");
        }
    }
  
}
