package com.kodilla.tictactoe.services.gameservice;

import com.kodilla.tictactoe.model.board.IBoard;
import com.kodilla.tictactoe.model.enums.PlayerType;
import com.kodilla.tictactoe.model.player.IPlayer;
import com.kodilla.tictactoe.model.player.Player;

import java.util.List;

public interface IGameService {
    void setGameSettings(PlayerType adversaryType, int boardSize);
    IBoard getBoard();
    void setupGame();
    int getBoardSize();
    boolean getIsGameOver();
    PlayerType getAdversaryType();
    void processPlayerMove(int x, int y, int playerIndex);
    void processAIMove();
    IPlayer getWinner();
    boolean checkIfCellIsTaken(int x, int y);
}
