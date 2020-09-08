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
    private Player player;
    private LifeLines lifelines;
    private Scoreboard playerScores;

    public Game() {
        questions = new ArrayList<>();
        loadQuestions();
        start();

    }

    private void start() {

        isOn = true;
        Scanner scan = new Scanner(System.in);
        playerScores = new Scoreboard();
        player = new Player();
        lifelines = new LifeLines(questions);
        String answer;
        System.out.println("Welcome to Who Wants to be a Millionaire");
        System.out.println("Enter player name: ");
        player.setPlayerName(scan.nextLine());
        System.out.println("Press 'Y' to start or press anything to close the game");
        String start = scan.nextLine();
        Collections.shuffle(questions);
        if ("y".equalsIgnoreCase(start)) {

            // During wihle loop
            while (isOn != false) {

                for (int i = 0; i < questions.size(); ++i) {
                    System.out.println(questions.get(i));
                    System.out.println("-------------------");
                    System.out.println("Life Line Avaliable");
                    System.out.println("-------------------");

                    if (lifelines.hintStatus() == false) {
                        System.out.println("1 for Hint");

                    }

                    answer = scan.nextLine();

                    if (answer.equalsIgnoreCase("1")) {
                        System.out.println(lifelines.getHintOn(i));
                        answer = scan.nextLine();
                    }

                    if (answer.equalsIgnoreCase(questions.get(i).getCorrectAnswer())) {
                        System.out.println("Correct!");
                        player.setWinnings(winnings.get(i));
                        
                        if (i == questions.size() - 1) {
                            System.out.println("Congratulations you are now a Millionair!!!");
                            System.out.println("*Queue default fornite dance music*");
                            isOn = false;
                            break;
                        }
                        
                        System.out.println("You have won $" + player.getWinnings() + " do want to continue?");
                        System.out.println("Enter n to exit, do any other input to continue");
                        String input = scan.nextLine();

                        if (input.equalsIgnoreCase("n")) { // ask if want to continue
                            System.out.println("Thanks for playing, You have won $" + player.getWinnings());
                            isOn = false;
                            break;
                        } else {
                            System.out.println("Next Question");
                        }

                        

                    } else {
                        if (i > 4) { // safe point for winnings

                            player.setWinnings(winnings.get(4));

                        } else {
                            player.setWinnings(0);
                        }

                        System.out.println("Incorrect answer, Thanks for playing!");
                        System.out.println("You have won $" + player.getWinnings());
                        isOn = false;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Thank you for playing! ");

        }
        playerScores.writeScores(player);
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
        Game game = new Game();

    }
}
