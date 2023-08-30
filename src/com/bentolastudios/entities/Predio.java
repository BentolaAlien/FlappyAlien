package com.bentolastudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bentolastudios.graficos.Sprites;
import com.bentolastudios.main.Game;
import com.bentolastudios.world.PredioGenerator;

public class Predio extends Entity{
	public Predio(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);

	}

	public void tick() {

		x--;
		if(x +width <= 0 ) {
			
			Game.entities.remove(this);
			return;
		}
	}
	public void render(Graphics g) {
		if(sprite == null) {
			g.drawImage(Sprites.PREDIO2,this.getX(),getY(),width,height,null);
			
		} else {
			g.drawImage(Sprites.PREDIO,this.getX(),getY(),width,height,null);
			

		}

		
		
	}
}
