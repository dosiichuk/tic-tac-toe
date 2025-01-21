package com.kodilla.tictactoe.model.boardcell;

import com.kodilla.tictactoe.model.enums.CellStatus;

import java.util.Objects;

public class BoardCell implements IBoardCell{
    private int x;
    private int y;
    private CellStatus cellStatus;

    public BoardCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.cellStatus = CellStatus.EMPTY;
    }

    @Override
    public int getXCoordinate() {
        return x;
    }

    @Override
    public int getYCoordinate() {
        return y;
    }

    @Override
    public CellStatus getCellStatus() {
        return cellStatus;
    }

    @Override
    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCell boardCell = (BoardCell) o;
        return x == boardCell.x && y == boardCell.y && cellStatus == boardCell.cellStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, cellStatus);
    }
}
