/***************************************************************
 * file: GameModel.java
 * author:   Christopher Santos
 *           Omar Rodriguez
 * class: CS 245 - Programming Graphical User Interfaces
 *
 * assignment: Swing Project v1.0
 * date last modified: 10/11/2016
 *
 * purpose: This is the model component for the game screen
 *
 ****************************************************************/
package co.edu.escuelaing.hangman.model;

import co.edu.escuelaing.hangman.model.dictionary.HangmanDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GameModel {
    private int incorrectCount;
    private int correctCount;
    private LocalDateTime dateTime;
    private int gameScorePoints;
    private int[] lettersUsed;


    private HangmanDictionary dictionary;

    private Scanner scan;
    private String randomWord;
    private char[] randomWordCharArray;

    private GameScore gameScore;


    @Autowired
    public GameModel(HangmanDictionary dictionary,GameScore gameScore) {
        //this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary = dictionary;
        this.gameScore = gameScore;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScorePoints = gameScore.calculateScore(correctCount,incorrectCount);


    }

    //method: reset
    //purpose: reset this game model for a new game
    public void reset() {
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScorePoints = gameScore.calculateScore(correctCount,incorrectCount);
    }

    //setDateTime
    //purpose: sets game date/time to system date/time
    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    //method: makeGuess
    //purpose: check if user guess is in string. Return a
    // list of positions if character is found in string
    public ArrayList<Integer> makeGuess(String guess) {
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < randomWordCharArray.length; i++) {
            if (randomWordCharArray[i] == guessChar) {
                positions.add(i);
            }
        }
        if (positions.size() == 0) {
            incorrectCount++;

        } else {
            correctCount += positions.size();
        }
        gameScorePoints = gameScore.calculateScore(correctCount,incorrectCount);
        return positions;

    }

    //getDateTime
    //purpose: returns current displayed date/time
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-dd-uuuu hh:mm:ss a");
        return dtf.format(dateTime);
    }

    //getScore
    //purpose: returns current score value
    public int getScore() {
        return gameScorePoints;
    }

    //setScore
    //purpose: sets score value to points
    public void setScore(int score) {
        this.gameScorePoints = gameScore.calculateScore(correctCount,incorrectCount);
    }

    //name: selectRandomWord()
    //purpose: selects random word from dictionary
    private String selectRandomWord() {
        Random rand = new Random();
        List<String> words = dictionary.getAvailableWords();
        return words.get(rand.nextInt(words.size()));
    }

    //method: getIncorrectCount
    //purpose: return number of incorrect guesses made so far
    public int getIncorrectCount() {
        return incorrectCount;
    }

    //method: getCorrectCount
    //purpose: return number of correct guesses made so far
    public int getCorrectCount() {
        return correctCount;
    }

    //method: getGameScore
    //purpose: return current score
    public int getGameScore() {
        return gameScorePoints;
    }

    //method: setGameScore
    //purpose: set current game score
    public void setGameScore(int gameScore) {
        this.gameScorePoints = gameScore;
    }

    //method: getWordLength
    //purpose: return length of current word
    public int getWordLength() {
        return randomWord.length();
    }

    public List<Character> getCharacterSet() {
        return new ArrayList<>(dictionary.getCharacterSet());
    }
}
