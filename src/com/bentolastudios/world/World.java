package com.bentolastudios.world;

import java.awt.Graphics;

import com.bentolastudios.entities.Player;

import com.bentolastudios.main.Game;

public class World {

	public static int WIDTH, HEIGHT;

	public World(String path) {

	}

	public static void restartGame() {
		Game.score = 0;
		Game.player = new Player(Game.WIDTH / 2 - 60, Game.HEIGHT / 2 - 70, 25, 25, 2,
				Game.spritesheet.getSprite(0, 0, 32, 32));

		Game.entities.clear();
		Game.entities.add(Game.player);

		return;
	}

	public void render(Graphics g) {


	}

}
