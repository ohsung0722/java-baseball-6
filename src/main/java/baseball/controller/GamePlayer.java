package baseball.controller;

import baseball.view.GamePhrases;

public class GamePlayer {
    GamePhrases gamePhrases;
    private boolean isEnteredGameEndingWord = true;
    public GamePlayer(GamePhrases gamePhrases){
        this.gamePhrases = gamePhrases;
    }
    public void playGameUntilCompletion(){
        while(isEnteredGameEndingWord){
            playGame();
        }
    }

    private void playGame(){
        gamePhrases.drawEnteredNumberComment();
    }
}
