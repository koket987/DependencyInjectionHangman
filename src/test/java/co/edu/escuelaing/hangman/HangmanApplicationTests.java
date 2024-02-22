package co.edu.escuelaing.hangman;

import co.edu.escuelaing.hangman.model.BonusScore;
import co.edu.escuelaing.hangman.model.GameScore;
import co.edu.escuelaing.hangman.model.OriginalScore;
import co.edu.escuelaing.hangman.model.PowerScore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class HangmanApplicationTests {
	private GameScore gameScore;

	@Test
	void shouldHaveTheCorrectPointsOriginalScore() {
    	gameScore = new OriginalScore();
		int score = gameScore.calculateScore(100,0);
		boolean comparator = score==100;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,100);
		comparator = score == 0;
		Assert.isTrue(comparator,"Correct");
	}
	@Test
	void shouldNotHaveTheCorrectPointsOriginalScore() {
		gameScore = new OriginalScore();
		int score = gameScore.calculateScore(100,0);
		boolean comparator = score != 99;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,100);
		comparator = score != -1;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,0);
		comparator = score != 101;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,1);
		comparator = score != 0;
		Assert.isTrue(comparator,"Correct");
	}

	@Test
	void shouldHaveTheCorrectPointsBonusScore() {
		gameScore = new BonusScore();
		int score = gameScore.calculateScore(1,0);
		boolean comparator = score == 10;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,1);
		comparator = score == 0;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,0);
		comparator = score == 0;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(100,20000);
		comparator = score == 0;
		Assert.isTrue(comparator,"Correct");
	}
	@Test
	void shouldNotHaveTheCorrectPointsBonusScore() {
		gameScore = new BonusScore();
		int score = gameScore.calculateScore(1,0);
		boolean comparator = score != 9;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,1);
		comparator = score != 1;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,0);
		comparator = score != 100;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(100,20000);
		comparator = score != -2000;
		Assert.isTrue(comparator,"Correct");
	}

	@Test
	void shouldHaveTheCorrectPointsPowerScore() {
		gameScore = new PowerScore();
		int score = gameScore.calculateScore(1,0);
		boolean comparator = score == 5;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(3,0);
		comparator = score == 125;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,2000);
		comparator = score == 0;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(10000,0);
		comparator = score == 500;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(5,350);
		comparator = score == 325;
		Assert.isTrue(comparator,"Correct");
	}
	@Test
	void shouldNotHaveTheCorrectPointsPowerScore() {
		gameScore = new PowerScore();
		int score = gameScore.calculateScore(0,0);
		boolean comparator = score != 5;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(5,0);
		comparator = score != 3125;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,2000);
		comparator = score != 16000;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(0,1);
		comparator = score != -8;
		Assert.isTrue(comparator,"Correct");
		score = gameScore.calculateScore(5,350);
		comparator = score != 500;
		Assert.isTrue(comparator,"Correct");
	}

}
