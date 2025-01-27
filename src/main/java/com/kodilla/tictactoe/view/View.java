package com.kodilla.tictactoe.view;

import com.kodilla.tictactoe.model.board.IBoard;
import com.kodilla.tictactoe.model.boardcell.IBoardCell;
import com.kodilla.tictactoe.model.enums.CellStatus;
import com.kodilla.tictactoe.model.enums.PlayerType;
import com.kodilla.tictactoe.services.gameservice.IGameService;

import java.util.Scanner;

public class View implements IView{
    private Scanner scanner = new Scanner(System.in);
    private IGameService gameService;

    public View(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void run() {
        determineGameSettings();
        setupGame();
        displayBoard();
        while (!gameService.getIsGameOver()) {
            int[] coordinatesInputByPlayer1 = takePlayerInput();
            gameService.processPlayerMove(coordinatesInputByPlayer1[0], coordinatesInputByPlayer1[1], 0);
            displayBoard();
            if (gameService.getIsGameOver()) {
                displayWinner();
                break;
            }
            if (gameService.getAdversaryType() == PlayerType.HUMAN) {
                System.out.println("Player 2's turn. Input coordinates.");
                int[] coordinatesInputByPlayer2 = takePlayerInput();
                gameService.processPlayerMove(coordinatesInputByPlayer2[0], coordinatesInputByPlayer2[1], 1);
                displayBoard();
                if (gameService.getIsGameOver()) {
                    displayWinner();
                    break;
                }
            } else {
                System.out.println("Player 2's turn. Input coordinates.");
                gameService.processAIMove();
                displayBoard();
                if (gameService.getIsGameOver()) {
                    displayWinner();
                    break;
                }
            }
        }
    }

    @Override
    public void determineGameSettings() {
        System.out.println("Wellcome to the Tic-Tac-Toe game! Let's determine settings.");
        PlayerType playerType = determinePlayerType();
        int boardSize = determineBoardSize();
        gameService.setGameSettings(playerType, boardSize);
    }

    @Override
    public void displayBoard() {
        System.out.println("Here is the current state of the board.");
        IBoard board = gameService.getBoard();
        int n = gameService.getBoardSize();
        String[][] displayBoard = new String[n][n];
        // Initialize the board with placeholders
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                displayBoard[i][j] = " ";
            }
        }
        for (IBoardCell cell : board.getBoardCells()) {
            switch (cell.getCellStatus()) {
                case CellStatus.TAKEN_BY_X -> displayBoard[cell.getXCoordinate()][cell.getYCoordinate()] = "X";
                case CellStatus.TAKEN_BY_Y -> displayBoard[cell.getXCoordinate()][cell.getYCoordinate()] = "O";
                case CellStatus.EMPTY -> displayBoard[cell.getXCoordinate()][cell.getYCoordinate()] = " ";
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(displayBoard[i][j]);
                if (j < n - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < n - 1) {
                System.out.println("-".repeat(n * 4 - 3));
            }
        }
    }

    @Override
    public int[] takePlayerInput() {
        System.out.println("Please enter the coordinates of the cell you would like to take. X Y");
        String userInput = scanner.nextLine();
        String[] coordinates = userInput.split(" ");
        try {
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            if (x < 0 || x >= gameService.getBoardSize() || y < 0 || y >= gameService.getBoardSize()) {
                System.out.println("This is not a valid input. Try again!");
                takePlayerInput();
            }
            if (gameService.checkIfCellIsTaken(x, y)) {
                System.out.println("This cell is already taken. Try again!");
                takePlayerInput();
            }
            return new int[]{x, y};
        } catch (Exception e) {
            System.out.println("This is not a valid input. Try again!");
            takePlayerInput();
        }
        return null;
    }

    @Override
    public void displayRoundResults() {

    }

    @Override
    public void displayWinner() {
        System.out.println("The winner is: " + gameService.getWinner().getPlayerType());
    }

    @Override
    public void restartGame() {

    }

    public PlayerType determinePlayerType() {
        System.out.println("Would you like to play with a human or a computer? 1-human, 2-computer");
        String userInput = scanner.nextLine();
        if (!userInput.equals("1") && !userInput.equals("2")) {
            determinePlayerType();
        } else if (userInput.equals("1")) {
            return PlayerType.HUMAN;
        } else {
            return PlayerType.COMPUTER;
        }
        return null;
    }

    public int determineBoardSize() {
        System.out.println("What is the size of the board you would like to play on?");
        String userInput = scanner.nextLine();
        try {
            int size = Integer.parseInt(userInput);
            if (size < 3) {
                System.out.println("The board size must be at least 3. Try again!");
                determineBoardSize();
            }
            return size;
        } catch (Exception e) {
            System.out.println("This is not a valid board size. Try again!");
            determineBoardSize();
        }
        return 0;
    }

    public void setupGame() {
        gameService.setupGame();
    }
}
