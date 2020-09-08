/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdcproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class Game {

    private final List<Integer> winnings = Arrays.asList(100, 200, 300, 500, 1000, 2000, 4000,
            8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000);
    private ArrayList<Question> questions;
    private boolean isOn;
    

    public Game() {
        questions = new ArrayList<>();
        loadQuestions();
        start();
    }

    private void start() {
        isOn = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Who Wants to be a Millionaire");
        System.out.println("Press 'Y' to start or press anything to close the game");
        String start = scan.nextLine();
        if ("y".equalsIgnoreCase(start)) {

            // During wihle loop
            while (isOn != false) {
                Collections.shuffle(questions);

                for (int i = 0; i < questions.size(); ++i) {
                    System.out.println(questions.get(i));
                }
            }
        }
        else{
            System.out.println("Thank you for playing!");
        }

        //After while loop
        // Thanks for playing, if they won or not, potential/what they want kidn of thing
    }

    private void loadQuestions() {
        BufferedReader readFile = null;
        try {
            readFile = new BufferedReader(new FileReader("questions.txt"));
            String readNext;
            while ((readNext = readFile.readLine()) != null) {
                // Grabbing information for each question
                String question = readNext;
                String answerOne = readFile.readLine();
                String answerTwo = readFile.readLine();;
                String answerThree = readFile.readLine();;
                String answerFour = readFile.readLine();;
                String correctAnswer = readFile.readLine();;
                String hint = readFile.readLine();;
                Question temp = new Question(question, answerOne, answerTwo, answerThree, answerFour, correctAnswer, hint);
                this.questions.add(temp);
            }
        } catch (IOException ex) {
            System.out.println("Can't read the file.");
        } finally {
            if (readFile != null) {
                try {
                    readFile.close();
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        Game test = new Game();

    }
}
