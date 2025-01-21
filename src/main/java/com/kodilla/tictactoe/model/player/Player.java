package com.kodilla.tictactoe.model.player;

import com.kodilla.tictactoe.model.enums.PlayerType;
import com.kodilla.tictactoe.model.enums.SignType;

public class Player implements IPlayer {
    private PlayerType playerType;
    private SignType signType;
    private int playerId;

    public Player(PlayerType playerType, int playerId, SignType signType) {
        this.playerType = playerType;
        this.playerId = playerId;
        this.signType = signType;
    }

    @Override
    public PlayerType getPlayerType() {
        return playerType;
    }

    @Override
    public int getPlayerId() {
        return playerId;
    }

    @Override
    public SignType getSignType() {
        return signType;
    }
}
