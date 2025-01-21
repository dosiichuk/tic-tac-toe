package com.kodilla.tictactoe.services.resultservice;

import com.kodilla.tictactoe.model.board.IBoard;
import com.kodilla.tictactoe.model.player.IPlayer;

public interface IResultService {
    boolean checkIfPlayerWonTheGame(IPlayer player, IBoard board, int x, int y);
}
