package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore implements GameScore{

    public int calculateScore(int correctCount, int incorrectCount) {
        int score = (correctCount * 10) - (incorrectCount * 5);
        return Math.max(score, 0);
    }
}
