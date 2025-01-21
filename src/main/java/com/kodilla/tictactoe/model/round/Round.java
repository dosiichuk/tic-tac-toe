package com.kodilla.tictactoe.model.round;

import com.kodilla.tictactoe.model.boardcell.IBoardCell;

public class Round implements IRound {
    private int roundNumber;
    private boolean isFinalRound;
    private IBoardCell boardCellTakenByPlayer1;
    private IBoardCell boardCellTakenByPlayer2;


    public Round(int roundNumber, boolean isFinalRound, IBoardCell boardCellTakenByPlayer1, IBoardCell boardCellTakenByPlayer2) {
        this.roundNumber = roundNumber;
        this.isFinalRound = isFinalRound;
        this.boardCellTakenByPlayer1 = boardCellTakenByPlayer1;
        this.boardCellTakenByPlayer2 = boardCellTakenByPlayer2;
    }

    @Override
    public int getRoundNumber() {
        return roundNumber;
    }

    @Override
    public IBoardCell getBoardCellTakenByPlayer1() {
        return boardCellTakenByPlayer1;
    }

    @Override
    public IBoardCell getBoardCellTakenByPlayer2() {
        return boardCellTakenByPlayer2;
    }

    @Override
    public boolean getIsFinalRound() {
        return isFinalRound;
    }
}
