package com.kodilla.tictactoe.services.resultservice;

import com.kodilla.tictactoe.model.board.IBoard;
import com.kodilla.tictactoe.model.enums.CellStatus;
import com.kodilla.tictactoe.model.enums.SignType;
import com.kodilla.tictactoe.model.player.IPlayer;

public class ResultService implements IResultService {

    @Override
    public boolean checkIfPlayerWonTheGame(IPlayer player, IBoard board, int x, int y) {
        SignType sign = player.getSignType();
        int boardSize = board.getBoardSize();
        CellStatus searchedCellStatus = player.getSignType() == SignType.CROSS ? CellStatus.TAKEN_BY_X :CellStatus.TAKEN_BY_Y;

        int winCondition = boardSize; // Number of consecutive signs needed to win

        boolean rowWin = true;
        for (int i = 0; i < boardSize; i++) {
            if (board.getBoardCell(x, i).getCellStatus() != searchedCellStatus) {
                rowWin = false;
                break;
            }
        }
        if (rowWin) return true;

        boolean colWin = true;
        for (int i = 0; i < boardSize; i++) {
            if (board.getBoardCell(i, y).getCellStatus() != searchedCellStatus) {
                colWin = false;
                break;
            }
        }
        if (colWin) return true;

        if (x == y) {
            boolean diagWin = true;
            for (int i = 0; i < boardSize; i++) {
                if (board.getBoardCell(i, i).getCellStatus() != searchedCellStatus) {
                    diagWin = false;
                    break;
                }
            }
            if (diagWin) return true;
        }

        if (x + y == boardSize - 1) {
            boolean antiDiagWin = true;
            for (int i = 0; i < boardSize; i++) {
                if (board.getBoardCell(i, boardSize - 1 - i).getCellStatus() != searchedCellStatus) {
                    antiDiagWin = false;
                    break;
                }
            }
            if (antiDiagWin) return true;
        }

        return false;

    }

}
