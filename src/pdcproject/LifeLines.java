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
public class LifeLines {

    private boolean hintOn = false;
    private ArrayList<Question> questions;

    public LifeLines(ArrayList<Question> questions){
        this.questions = questions;
        
    }
    public String getHintOn(int questionNumber) {
        hintOn = true;
        return questions.get(questionNumber).getHint();
        
    }
    
    public boolean hintStatus() {
        return hintOn;
    }

    

}
