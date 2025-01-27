package com.kodilla.tictactoe.services.gameservice;

import com.kodilla.tictactoe.model.board.Board;
import com.kodilla.tictactoe.model.board.IBoard;
import com.kodilla.tictactoe.model.boardcell.IBoardCell;
import com.kodilla.tictactoe.model.enums.CellStatus;
import com.kodilla.tictactoe.model.enums.PlayerType;
import com.kodilla.tictactoe.model.enums.SignType;
import com.kodilla.tictactoe.model.player.IPlayer;
import com.kodilla.tictactoe.model.player.Player;
import com.kodilla.tictactoe.services.aiplayerservice.IAIPlayerService;
import com.kodilla.tictactoe.services.eventbus.IEventBus;
import com.kodilla.tictactoe.services.resultservice.IResultService;

import java.util.ArrayList;
import java.util.List;

public class GameService implements IGameService{
    private int boardSize;
    private PlayerType adversaryType;
    private List<IPlayer> players;
    private IBoard board = null;
    private IEventBus eventBus;
    private IResultService resultService;
    private final IAIPlayerService aiPlayerService;
    private boolean isGameOver;
    private IPlayer winner;

    public GameService(IResultService resultService, IAIPlayerService aiPlayerService) {
        this.resultService = resultService;
        this.aiPlayerService = aiPlayerService;
    }

    @Override
    public void setGameSettings(PlayerType adversaryType, int boardSize) {
        this.adversaryType = adversaryType;
        this.boardSize = boardSize;
    }

    @Override
    public void setupGame() {
        players = new ArrayList<>();
        IPlayer player1 = new Player(PlayerType.HUMAN, 0, SignType.CROSS);
        IPlayer player2 = new Player(adversaryType, 1, SignType.ZERO);
        players.add(player1);
        players.add(player2);
    }

    @Override
    public void processPlayerMove(int x, int y, int playerIndex) {
        IBoardCell cell = getBoard().getBoardCell(x, y);
        cell.setCellStatus(players.get(playerIndex).getSignType() == SignType.CROSS ? CellStatus.TAKEN_BY_X : CellStatus.TAKEN_BY_Y);
        boolean hasPlayerWon = resultService.checkIfPlayerWonTheGame(players.get(playerIndex), getBoard(), x, y);
        if (hasPlayerWon) {
            isGameOver = true;
            winner = players.get(playerIndex);
        }
    }

    @Override
    public boolean checkIfCellIsTaken(int x, int y) {
        return getBoard().getBoardCells().stream()
                .anyMatch(cell -> cell.getXCoordinate() == x && cell.getYCoordinate() == y && cell.getCellStatus() != CellStatus.EMPTY);
    }

    @Override
    public void processAIMove() {
        int[] coordinates = aiPlayerService.makeMove(boardSize);
        boolean isCellTaken = checkIfCellIsTaken(coordinates[0], coordinates[1]);
        if (!isCellTaken) {
            processPlayerMove(coordinates[0], coordinates[1], 1);
        } else {
            processAIMove();
        }
    }

    @Override
    public IBoard getBoard() {
        if (board == null) {
            board = new Board(boardSize);
            return board;
        }
        return board;
    }

    @Override
    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public PlayerType getAdversaryType() {
        return adversaryType;
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    @Override
    public boolean getIsGameOver() {
        return isGameOver;
    }

    @Override
    public IPlayer getWinner() {
        return winner;
    }


}
