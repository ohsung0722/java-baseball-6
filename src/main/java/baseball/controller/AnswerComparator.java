package baseball.controller;

import baseball.view.GamePhrases;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class AnswerComparator {
    GamePhrases gamePhrases;
    ExceptionHandler exceptionHandler;
    public AnswerComparator(GamePhrases gamePhrases){
        this.gamePhrases = gamePhrases;
        this.exceptionHandler = new ExceptionHandler();
    }
    public boolean isCompareAnswer(List<Integer> randomNumbers){
        List<Integer> userInputNumber = convertStringToList(getUserInputNumber());
        int strike = countStrike(userInputNumber, randomNumbers);
        int ball = countBall(userInputNumber, randomNumbers);

        return isSelectPrintType(strike, ball, userInputNumber, randomNumbers);
    }

    private String getUserInputNumber(){
        String userInputNumber = Console.readLine();

        exceptionHandler.userInputException(userInputNumber);

        return userInputNumber;
    }

    //문자열을 리스트형으로 바꿔주는 함수
    private List<Integer> convertStringToList(String userInputNumber){
        List<Integer> userInputNumbers = new ArrayList<>();

        for(int i = 0; i < userInputNumber.length(); i++){
            char character = userInputNumber.charAt(i);
            int number = Character.getNumericValue(character);
            userInputNumbers.add(number);
        }

        return userInputNumbers;
    }

    //strike 개수를 세주는 함수
    private int countStrike(List<Integer> firstNumber, List<Integer> secondNumber){
        int strike = 0;

        for(int i = 0; i < firstNumber.size(); i++){
            if(firstNumber.get(i).equals(secondNumber.get(i))){
                strike++;
            }
        }

        return strike;
    }

    //ball 개수를 세주는 함수
    private int countBall(List<Integer> firstNumber, List<Integer> secondNumber){
        int ball = 0;

        for(int i = 0; i < firstNumber.size(); i++){
            if(firstNumber.get(i).equals(secondNumber.get(i))){
                continue;
            }

            if(secondNumber.contains(firstNumber.get(i))){
                ball++;
            }
        }

        return ball;
    }

    //정답과 일치하는지 판별해주는 함수
    private boolean isCheckCorrectAnswer(List<Integer> firstNumber, List<Integer> secondNumber){
        for(int i = 0; i < firstNumber.size(); i++){
            if(!firstNumber.get(i).equals(secondNumber.get(i))){
                return false;
            }
        }

        return true;
    }

    //결과에 따라 출력할 문장을 결정해주는 함수
    private boolean isSelectPrintType(int strike, int ball, List<Integer> firstNumber, List<Integer> secondNumber){
        if(isCheckCorrectAnswer(firstNumber, secondNumber)){
            gamePhrases.printStrikeComment(strike);
            gamePhrases.printEndingComment();
            return true;
        }

        if(strike == 0 && ball == 0){
            gamePhrases.printNothingComment();
        } else if(strike == 0){
            gamePhrases.printBallComment(ball);
        } else if(ball == 0){
            gamePhrases.printStrikeComment(strike);
        } else{
            gamePhrases.printBallAndStrikeComment(ball, strike);
        }
        return false;
    }
}
