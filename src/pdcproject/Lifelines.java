/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdcproject;

import java.util.ArrayList;

/**
 *
 * @author Gerad Gomez and Victor Feng
 */
public class Lifelines {
    public boolean HintOn = false;
    private Game game = new Game();
    private ArrayList<Question> questions;


    public boolean getHintOn() {
        return HintOn;
    }
    
    public void runHint(int i)
    {
        System.out.println("Hint Used");
        System.out.println(questions.get(i).getHint());
        HintOn=true;
    }
    
}
