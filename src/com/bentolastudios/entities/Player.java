package com.bentolastudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bentolastudios.main.Game;
import com.bentolastudios.main.Sound;
import com.bentolastudios.world.World;

public class Player extends Entity {

	public boolean isPressed = false;
	public double vy = 0;
	public static double G = 500;
	public static double FLAP = -300;
	public int time = -50;
	
	
	private int frames = 0, maxFrames = 40,index = 0,maxIndex = 4;
	private BufferedImage[] NaveAlien;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		NaveAlien = new BufferedImage[5];
		for (int i = 0; i < 5; i++) {
			NaveAlien[i] = Game.spritesheet.getSprite(0 + (i * 32), 0, 32, 32);
		}
	}


	public void tick() {
		time++;
		if(time == 45) {
			Game.score+= 0.5;
			time = 0;
		}
		frames++;
		if(frames > maxFrames) {
			frames = 0;
			index++;
			if(index >maxIndex) {
				index = 0;
			}}
		depth = 2;
		if (!isPressed) {
			y+=3;
		} else {
			if(y>0) {
				y-= Entity.rand.nextInt(5);
			}	
		}
			
		if (y > Game.HEIGHT && Game.gameState == "RUNNINGIZ") {
			Sound.diedMusic.play();
			Game.gameState = "GAME_OVERIZ";
			
			return;
		}
		if (y > Game.HEIGHT && Game.gameState == "RUNNING") {
			Sound.diedMusic.play();
			Game.gameState = "GAME_OVER";
			
			return;
		}
		
		
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e != this) {
				if (Entity.isColidding(this, e) && Game.gameState == "RUNNINGIZ") {
					Sound.diedMusic.play();
					Game.gameState = "GAME_OVERIZ";
					
					return;
				}
				if (Entity.isColidding(this, e)&& Game.gameState == "RUNNING") {
					Sound.diedMusic.play();
					Game.gameState = "GAME_OVER";
				
					return;
				}
				
			}
		}

	}
	public void render(Graphics g) {
		g.drawImage(NaveAlien[index], this.getX(), this.getY(), null);
	}
}
