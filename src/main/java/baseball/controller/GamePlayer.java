package baseball.controller;

import baseball.view.GamePhrases;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GamePlayer {
    private GamePhrases gamePhrases;
    private RandomNumberGenerator randomNumberGenerator;
    private boolean isEnteredGameEndingWord = false;
    public GamePlayer(GamePhrases gamePhrases){
        this.gamePhrases = gamePhrases;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }
    public void playGameUntilCompletion(){
        //2를 눌러 종료할 때 까지 루프를 돌리기 위한 반복문
        while(!isEnteredGameEndingWord){
            playGame();
        }
    }

    private void playGame(){
        //정답을 맞출 때 까지 루프를 돌리기 위한 반복문
        boolean isCorrectNumber = false;

        List<Integer> randomNumber = randomNumberGenerator.generateRandomNumbers();

        while(!isCorrectNumber){
            gamePhrases.printEnteredNumberComment();
            Console.readLine();
        }

    }


}
