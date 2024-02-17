package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

@Component("originalScore")
public class OriginalScore  implements  GameScore{
    public int calculateScore(int correctCount, int incorrectCount) {
        int score = (incorrectCount * 10) + 100;
        if(score<0){
            return  0;
        }else{
            return score;
        }
    }
}
