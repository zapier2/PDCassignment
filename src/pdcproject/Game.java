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
    private Scanner scan;

    public Game() {
        questions = new ArrayList<>();
        loadQuestions();
        start();
    }

    private void start() {

        isOn = true;
        scan = new Scanner(System.in);
        playerScores = new Scoreboard();
        player = new Player();
        lifelines = new LifeLines(questions);
        String answer = "";
        String hint;
        //  Input player name
        System.out.println("Welcome to Who Wants to be a Millionaire");
        System.out.println("Enter player name: ");
        player.setPlayerName(scan.nextLine());

        System.out.println("Press 'Y' to start or press anything to close the game");
        String start = scan.nextLine();

        //  index for number of hints
        int hintCounter = 3;
        Collections.shuffle(questions);
        if ("y".equalsIgnoreCase(start)) {

            // During wihle loop
            while (isOn != false) {

                for (int i = 0; i < questions.size(); ++i) {
                    //  Displaying the avaliable Hints
                    System.out.print("Question " + (i + 1) + ") ");
                    System.out.print(questions.get(i));
                    System.out.println("");
                    System.out.println("-------------------");
                    System.out.println("Life Line Avaliable");
                    System.out.println("-------------------");

                    if (lifelines.hintStatus() == false) { // Display the number of Hints currently avaliable
                        System.out.println("Press (1) for Hint (You have " + hintCounter + " left)");

                    } else {
                        System.out.println("You have no more hints left!");
                    }

                    if (hintCounter < 2) {
                        lifelines.setStatus(true);
                    }
                    //  Scan to check for answer input or Hint

                    hint = scan.nextLine();

                    if (hint.equalsIgnoreCase("1")) {//   when hint is used
                        hintCounter--;
                        System.out.println(lifelines.getHintOn(i));
                        hint = scan.nextLine();
                    }

                    if (hint.equalsIgnoreCase(questions.get(i).getCorrectAnswer())) {  //  When answer is correct

                        System.out.println("Correct!");
                        player.setWinnings(winnings.get(i));

                        if (i == questions.size() - 1) {//  When winnings reached max
                            System.out.println("Congratulations you are now a Millionair!!!");
                            System.out.println("*Queue default fornite dance music*");
                            saveWinnings(answer);
                            isOn = false;
                            break;
                        }

                        //  Display current winnings if answered questions correctly
                        //  and ask if player wanted to continue
                        System.out.println("You have won $" + player.getWinnings() + " do want to continue?");
                        System.out.println("Enter n to exit, do any other input to continue");
                        answer = scan.nextLine();

                        if (answer.equalsIgnoreCase("n")) { // ask if want to continue
                            System.out.println("You have won $" + player.getWinnings());
                            saveWinnings(answer);
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
                        saveWinnings(answer);

                        isOn = false;
                        break;
                    }
                }
            }
        } else {
            System.out.println("See you next time! ");

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

    public void saveWinnings(String save) {
        
        System.out.println("Would you like to save you winnings? (Y) for yes or (N) for no");
        save = scan.nextLine();
        if (save.equalsIgnoreCase("y")) {
            playerScores.writeScores(player);
        } else if (save.equalsIgnoreCase("n")) {
            System.out.println("Thanks for playing!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
    }
}
