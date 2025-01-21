package com.kodilla.tictactoe.view;

public interface IView {
    void determineGameSettings();
    void displayBoard();
    int[] takePlayerInput();
    void displayRoundResults();
    void displayWinner();
    void restartGame();
    void run();
}
