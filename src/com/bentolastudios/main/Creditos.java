package com.bentolastudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bentolastudios.graficos.Sprites;

public class Creditos {

	public String[] options = { "voltar" };

	public int currentOption = 0;
	public int maxOption = options.length - 1;

	public boolean up, down, enter;

	public void tick() {
		Sound.musicIZ.stop();
		currentOption = 0;

		if (enter) {

			enter = false;

			if (options[currentOption] == "voltar") {
				Sound.selected.play();
				Game.gameState = "MENU";
			}
		}
	}

	public void render(Graphics g) {
		// Fundo Menu
		g.drawImage(Sprites.CREDITOS, 0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, null);

		//Opcoes de menu
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,24));

				g.drawImage(Sprites.VOLTAR, (Game.WIDTH * Game.SCALE) / 2 - 65, 530, Game.WIDTH - 50 , 150, null);

	}

}
