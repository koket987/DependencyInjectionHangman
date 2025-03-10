package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

@Component("powerScore")
public class PowerScore implements GameScore{

    public int calculateScore(int correctCount, int incorrectCount) {
        int score = 0;
        score += Math.pow(5, correctCount);
        score -= (incorrectCount * 8);
        if (score < 0) {
            return 0;
        } else if (score > 500) {
            return 500;
        } else {
            return score;
        }
    }
}
