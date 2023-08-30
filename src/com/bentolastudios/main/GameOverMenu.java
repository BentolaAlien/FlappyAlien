package com.bentolastudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bentolastudios.graficos.Sprites;
import com.bentolastudios.world.World;

public class GameOverMenu {

	public String[] options = { "restart", "home" };

	public int currentOption = 0;
	public int maxOption = options.length - 1;

	public boolean left, right, enter;

	private boolean showMessageGameOver = true;
	private boolean showMessageGameOver1 = true;
	private int framesGameOver = 0;

	public Menu menu;

	// Funções Menu
	public void tick() {

		if (right) {
			Sound.menuOp.play();
			right = false;
			currentOption--;
			if (currentOption < 0)
				currentOption = maxOption;
		}
		if (left) {
			Sound.menuOp.play();
			left = false;
			currentOption++;
			if (currentOption > maxOption)
				currentOption = 0;
		}
		if (enter) {
			enter = false;


			if (options[currentOption] == "restart") {
				World.restartGame();
				Sound.selected.play();
				Game.gameState = "RUNNING";

			} else if (options[currentOption] == "home") {
				Sound.selected.play();
				Sound.musicHard.stop();
				Sound.menuBackground.play();
				Game.gameState = "MENU";
			}
		}

		this.framesGameOver++;
		if (this.framesGameOver == 30) {
			this.framesGameOver = 0;
			if (this.showMessageGameOver1) {
				this.showMessageGameOver1 = false;
			} else {
				this.showMessageGameOver1 = true;
			}
		}

	}

	public void render(Graphics g) {
		g.drawImage(Sprites.BACKGROUNDGAMEOVER, 0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, null);
		// Sprite Game Over
		if (showMessageGameOver1) {
			g.drawImage(Sprites.GAMEOVER, 25, 120, 300, 300, null);
		}

		// Opções menu
		if (showMessageGameOver) {

			g.drawImage(Sprites.RESTART, 70, 400, 100, 100, null);
			g.drawImage(Sprites.HOME, 200, 400, 100, 100, null);

			if (options[currentOption] == "restart") {
				g.drawImage(Sprites.RESTARTP, 70, 400, 100, 100, null);
			} else if (options[currentOption] == "home") {
				g.drawImage(Sprites.HOMEP, 200, 400, 100, 100, null);
			}
		}
	}

}
