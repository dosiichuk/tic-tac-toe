package com.kodilla.tictactoe.model.player;

import com.kodilla.tictactoe.model.enums.PlayerType;

public class Player implements IPlayer {
    private PlayerType playerType;
    private int playerId;

    @Override
    public PlayerType getPlayerType() {
        return playerType;
    }

    @Override
    public int getPlayerId() {
        return playerId;
    }
}
