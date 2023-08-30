package com.bentolastudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bentolastudios.graficos.Sprites;
import com.bentolastudios.world.World;



public class Difficulty {
	
	public String[] options = { "iz", "hard", "voltar" };

	public int currentOption = 0;
	public int maxOption = options.length - 1;

	public boolean up, down, enter;

	
	public void tick() {
		Sound.musicIZ.stop();
		if (up) {
			System.out.println("up");
			Sound.menuOp.play();
			up = false;
			currentOption--;
			if (currentOption < 0)
				currentOption = maxOption;
		}
		if (down) {
			System.out.println("d");
			Sound.menuOp.play();
			down = false;
			currentOption++;
			if (currentOption > maxOption)
				currentOption = 0;
		}
		if (enter) {

		
			enter = false;
			if (options[currentOption] == "iz") {
				World.restartGame();
				Sound.selected.play();
				Sound.musicIZ.play();
				Game.gameState = "RUNNINGIZ";
			} else if(options[currentOption] == "hard") {
				World.restartGame();
				Sound.selected.play();
				Sound.musicHard.play();
				Game.gameState = "RUNNING";
			} else if(options[currentOption] == "voltar") {
				Sound.selected.play();
				Game.gameState = "MENU";
			}
		}
	}

	public void render(Graphics g) {
		// Fundo Menu
		g.drawImage(Sprites.BACKGROUNDMENU, 0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,36));
		
		g.drawImage(Sprites.DIFICULDADEN, (Game.WIDTH * Game.SCALE) / 2 -170 , 100, Game.WIDTH + 160 , 70, null);
		
		//Opcoes de menu
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,24));

			g.drawString("IZ", (Game.WIDTH*Game.SCALE) / 2 - 50, 400);
			g.drawString("HARD", (Game.WIDTH*Game.SCALE) / 2 - 50, 450);
			g.drawImage(Sprites.VOLTAR, (Game.WIDTH * Game.SCALE) / 2 - 160, 500, Game.WIDTH - 20 , 180, null);
		
		if(options[currentOption] == "iz") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 90, 400);
		}else if(options[currentOption] == "hard") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 90, 450);
		}else if(options[currentOption] == "voltar") {
			g.drawImage(Sprites.VOLTARP, (Game.WIDTH * Game.SCALE) / 2 - 160, 500, Game.WIDTH - 20 , 180, null);
			}
		
		
	}

}
