package com.kodilla.tictactoe.services.aiplayerservice;

public class AIPlayerService implements IAIPlayerService {

    @Override
    public int[] makeMove(int boardSize) {
        int x = (int) (Math.random() * boardSize);
        int y = (int) (Math.random() * boardSize);
        return new int[]{x, y};
    }
}
