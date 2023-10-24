package baseball.controller;

public class ExceptionHandler {
    //잘못된 값을 입력한 경우 에러를 발생시키는 함수
    public void userInputException(String number){
        lengthException(number);
        numberException(number);
        containZero(number);
    }

    //입력한 숫자가 세자리가 아닌 경우
    private void lengthException(String number){
        if(number.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    //입력한 값이 숫자가 아닌 경우
    private void numberException(String number){
        if(!isNumberException(number)){
            throw new IllegalArgumentException();
        }
    }

    //입력한 값이 숫자로 변환 가능한지 아닌지 판별해주는 함수
    private boolean isNumberException(String number){
        try{
            Integer.parseInt(number);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    //입력한 값 중 0이 포함되어 있는지 아닌지 판별해주는 함수
    private void containZero(String number){
        if(number.contains("0")){
            throw new IllegalArgumentException();
        }
    }
}
