package com.kodilla.tictactoe.model.board;

import com.kodilla.tictactoe.model.boardcell.BoardCell;
import com.kodilla.tictactoe.model.boardcell.IBoardCell;

import java.util.ArrayList;
import java.util.List;

public class Board implements IBoard {
    private int size;
    private List<IBoardCell> boardCells;

    public Board(int size) {
        this.size = size;
        initializeBoardCells(size);
    }

    @Override
    public void initializeBoardCells(int boardSize) {
        this.boardCells = new ArrayList<>();
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                boardCells.add(new BoardCell(i, j));
            }
        }
    }

    @Override
    public List<IBoardCell> getBoardCells() {
        return boardCells;
    }

    @Override
    public IBoardCell getBoardCell(int x, int y) {
        return boardCells.stream()
                .filter(cell -> cell.getXCoordinate() == x && cell.getYCoordinate() == y)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getBoardSize() {
        return size;
    }
}
