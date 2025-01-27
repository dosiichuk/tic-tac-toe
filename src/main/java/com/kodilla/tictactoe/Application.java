package com.kodilla.tictactoe;

import com.kodilla.tictactoe.services.aiplayerservice.AIPlayerService;
import com.kodilla.tictactoe.services.gameservice.GameService;
import com.kodilla.tictactoe.services.gameservice.IGameService;
import com.kodilla.tictactoe.services.resultservice.IResultService;
import com.kodilla.tictactoe.services.resultservice.ResultService;
import com.kodilla.tictactoe.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		IGameService gameService = new GameService(new ResultService(), new AIPlayerService());
		new View(gameService).run();
	}

}
