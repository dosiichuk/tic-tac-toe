package com.kodilla.tictactoe.model.player;

import com.kodilla.tictactoe.model.enums.PlayerType;
import com.kodilla.tictactoe.model.enums.SignType;

public interface IPlayer {
    PlayerType getPlayerType();
    int getPlayerId();
    SignType getSignType();
}
