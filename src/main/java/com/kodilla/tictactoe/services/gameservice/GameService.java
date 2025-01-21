package com.kodilla.tictactoe.services.gameservice;

import com.kodilla.tictactoe.model.board.Board;
import com.kodilla.tictactoe.model.board.IBoard;
import com.kodilla.tictactoe.model.enums.PlayerType;
import com.kodilla.tictactoe.model.enums.SignType;
import com.kodilla.tictactoe.model.player.IPlayer;
import com.kodilla.tictactoe.model.player.Player;
import com.kodilla.tictactoe.services.eventbus.IEventBus;
import com.kodilla.tictactoe.services.resultservice.IResultService;

import java.util.ArrayList;
import java.util.List;

public class GameService implements IGameService{
    private int boardSize;
    private PlayerType adversaryType;
    private List<IPlayer> players;
    private IBoard board;
    private IEventBus eventBus;
    private IResultService resultService;
    private boolean isGameOver;

    public GameService(IResultService resultService) {
        this.resultService = resultService;
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
        boolean hasPlayerWon = resultService.checkIfPlayerWonTheGame(players.get(playerIndex), board, x, y);
    }

    @Override
    public void processAIMove() {

    }

    @Override
    public IBoard getBoard() {
        if (board == null) {
            return new Board(boardSize);
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

    public IEventBus getEventBus() {
        return eventBus;
    }

    @Override
    public boolean getIsGameOver() {
        return isGameOver;
    }


}
