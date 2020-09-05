/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdcproject;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gerar
 */
public class Question {
//    private final List<Integer> winnings = Arrays.asList(100, 200, 300, 500, 1000, 2000, 4000,
//    8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000);
    private String question;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    private String correctAnswer;
    private String hint;
    
    public Question(String question, String answerOne, String answerTwo, String answerThree, String answerFour, String correctAnswer, String hint) {
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getHint() {
        return hint;
    }
    
    @Override
    public String toString() {
        return "Question: " + this.question + "\n" + this.answerOne + "\n" + this.answerTwo + "\n" + this.answerThree + "\n" + this.answerFour;
    }
}
