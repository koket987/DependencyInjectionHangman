package co.edu.escuelaing.hangman.model;

public interface GameScore {
    /*
    @pre
    @pos
    @param
    @throws

     */
    public abstract int calculateScore(int correctCount, int incorrectCount);
}
