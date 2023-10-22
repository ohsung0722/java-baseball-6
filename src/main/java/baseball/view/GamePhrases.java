package baseball.view;

public class GamePhrases {
    public void drawStartComment(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void drawEnteredNumberComment(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void drawStrikeComment(int strike){
        System.out.println(strike + "스트라이크");
    }

    public void drawBallComment(int ball){
        System.out.println(ball + "볼");
    }

    public void drawBallAndStrikeComment(int ball, int strike){
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    public void drawEndingComment(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
