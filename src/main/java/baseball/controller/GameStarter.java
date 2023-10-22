package baseball.controller;

import baseball.view.GamePhrases;

public class GameStarter {
    GamePhrases gamePhrases;
    GamePlayer gamePlayer;

    public GameStarter(){
        this.gamePhrases = new GamePhrases();
        this.gamePlayer = new GamePlayer(gamePhrases);
    }

    public void startGame(){
        gamePhrases.printStartComment();
        gamePlayer.playGameUntilCompletion();
    }
}
