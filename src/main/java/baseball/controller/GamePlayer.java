package baseball.controller;

import baseball.view.GamePhrases;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GamePlayer {
    private GamePhrases gamePhrases;
    private RandomNumberGenerator randomNumberGenerator;
    private AnswerComparator answerComparator;

    public GamePlayer(GamePhrases gamePhrases){
        this.gamePhrases = gamePhrases;
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.answerComparator = new AnswerComparator(gamePhrases);
    }
    public void playGameUntilCompletion(){
        boolean isEnteredGameEndingWord = true;
        //2를 눌러 종료할 때 까지 루프를 돌리기 위한 반복문
        while(isEnteredGameEndingWord){
            playGame();
            isEnteredGameEndingWord = isGameContinued();
        }
    }

    private void playGame(){
        boolean isCorrectNumber = false;

        List<Integer> randomNumber = randomNumberGenerator.generateRandomNumbers();

        //정답을 입력할 때 까지 루프를 돌리기 위한 반복문
        while(!isCorrectNumber){
            gamePhrases.printEnteredNumberComment();
            isCorrectNumber = answerComparator.isCompareAnswer(randomNumber);
        }
    }

    //게임을 계속 할지 아닐지 여부를 판단하는 함수
    private boolean isGameContinued(){
        String userDecision = getUserDecision();

        if(userDecision.equals("1")) {
            return true;
        } else if(userDecision.equals("2")){
            return false;
        } else{
            throw new IllegalArgumentException();
        }
    }

    //게임 지속에 대한 사용자 의견을 리턴받는 함수
    private String getUserDecision(){
        return Console.readLine();
    }

}
