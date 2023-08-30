package com.bentolastudios.world;

import com.bentolastudios.entities.Entity;
import com.bentolastudios.entities.Predio;
import com.bentolastudios.main.Game;

public class PredioGeneratoriz {

	public int time = 0;


	public void tick() {

		time++;

		if (time == 70) {

			//adicionar predio 1
			int altura1 = Entity.rand.nextInt(140 - 50) + 10;
			Predio predio1 = new Predio(Game.WIDTH, 0, 40, altura1, 1, null);

			Game.entities.add(predio1);
			
			//adicionar predio 2
			int altura2 = Entity.rand.nextInt(140 - 50) + 10;
			Predio predio2 = new Predio(Game.WIDTH, Game.HEIGHT - altura2, 40, altura2, 1,
					Game.cano.getSprite(0, 0, 52, 320));

			Game.entities.add(predio2);

			time = 0;
		}

	}

}
