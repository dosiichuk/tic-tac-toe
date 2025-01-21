package com.kodilla.tictactoe.model.player;

import com.kodilla.tictactoe.model.enums.PlayerType;

public interface IPlayer {
    PlayerType getPlayerType();
    int getPlayerId();
}
