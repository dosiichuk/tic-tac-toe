package com.kodilla.tictactoe.model.boardcell;

import com.kodilla.tictactoe.model.enums.CellStatus;

public interface IBoardCell {
    int getXCoordinate();
    int getYCoordinate();
    CellStatus getCellStatus();
    void setCellStatus(CellStatus cellStatus);
}
