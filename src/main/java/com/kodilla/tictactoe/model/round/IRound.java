package com.kodilla.tictactoe.model.round;

import com.kodilla.tictactoe.model.boardcell.IBoardCell;

public interface IRound {
    int getRoundNumber();
    IBoardCell getBoardCellTakenByPlayer1();
    IBoardCell getBoardCellTakenByPlayer2();
    boolean getIsFinalRound();
}
