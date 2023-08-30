package com.bentolastudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bentolastudios.graficos.Sprites;

public class Menu {

	public String[] options = { "novo jogo", "sair","creditos", "music on", "music off" };

	public int currentOption = 0;
	public int maxOption = options.length - 1;

	public boolean up, down, enter;

	// Funções Menu
	public void tick() {

		if (up) {
			Sound.menuOp.play();
			up = false;
			currentOption--;
			if (currentOption < 0)
				currentOption = maxOption;
		}
		if (down) {
			Sound.menuOp.play();
			down = false;
			currentOption++;
			if (currentOption > maxOption)
				currentOption = 0;
		}
		if (enter) {

			
			enter = false;
			if (options[currentOption] == "novo jogo") {
				Sound.selected.play();
				Game.gameState = "DIFICULDADE";

			} else if (options[currentOption] == "sair") {
				Sound.selected.play();
				System.exit(1);
			} else if (options[currentOption] == "creditos") {
				Sound.selected.play();
				Game.gameState = "CREDITO";
			}	else if (options[currentOption] == "music on") {
				Sound.menuBackground.play();


			}
			if (options[currentOption] == "music off") {
				Sound.menuBackground.stop();

			}
		}
	}

	public void render(Graphics g) {

		// Fundo Menu
		g.drawImage(Sprites.BACKGROUNDMENU, 0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, null);

		// Nome Jogo Menu
		g.drawImage(Sprites.TITULO, (Game.WIDTH * Game.SCALE) / 2 - 160, 70, Game.WIDTH + 150, 150, null);
		// Opcoes de menu
		g.drawImage(Sprites.PLAY, (Game.WIDTH * Game.SCALE) / 2 - 90, 250, Game.WIDTH, 200, null);
		g.drawImage(Sprites.EXIT, (Game.WIDTH * Game.SCALE) / 2 - 90, 400, Game.WIDTH, 200, null);

		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, 24));
		g.drawString("CREDITOS", (Game.WIDTH * Game.SCALE) / 2 - 50, 600);
		g.drawString("Music on", (Game.WIDTH * Game.SCALE) / 2 - 170, 600);
		g.drawString("Music off", (Game.WIDTH * Game.SCALE) / 2 - 170, 620);

		if (options[currentOption] == "novo jogo") {
			g.drawImage(Sprites.PLAYP, (Game.WIDTH * Game.SCALE) / 2 - 90, 250, Game.WIDTH, 200, null);
		} else if (options[currentOption] == "sair") {
			g.drawImage(Sprites.EXITP, (Game.WIDTH * Game.SCALE) / 2 - 90, 400, Game.WIDTH, 200, null);
		} else if (options[currentOption] == "creditos") {
			g.drawString("<", (Game.WIDTH * Game.SCALE) / 2 + 80 , 600);
		} else if (options[currentOption] == "music on") {
			g.drawString("<", (Game.WIDTH * Game.SCALE) / 2 - 70, 600);
		} else if (options[currentOption] == "music off") {
			g.drawString("<", (Game.WIDTH * Game.SCALE) / 2 - 70, 620);
		}
	}

}
