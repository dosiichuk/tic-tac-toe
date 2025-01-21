package com.kodilla.tictactoe.model.board;

import com.kodilla.tictactoe.model.boardcell.IBoardCell;

import java.util.List;

public interface IBoard {
    List<IBoardCell> getBoardCells();
    IBoardCell getBoardCell(int x, int y);
    void initializeBoardCells(int boardSize);
    int getBoardSize();
}