package com.bentolastudios.graficos;

import java.awt.image.BufferedImage;

import com.bentolastudios.main.Game;

public class Sprites {
	
	public static BufferedImage TITULO = Game.titulo.getSprite(0, 0, 192, 64);
	
	//Background e Game Over
	public static BufferedImage BACKGROUND = Game.background.getSprite(0, 0, 360, 640);
	public static BufferedImage BACKGROUNDHARD = Game.backgroundhard.getSprite(0, 0, 360, 640);
	public static BufferedImage BACKGROUNDMENU = Game.backgroundmenu.getSprite(0, 0, 360, 640);
	public static BufferedImage CREDITOS = Game.creditos.getSprite(0, 0, 360, 640);
	public static BufferedImage GAMEOVER = Game.gameover.getSprite(0, 0, 128, 128);
	public static BufferedImage DIFICULDADEN = Game.dificuldadeN.getSprite(0, 0, 316, 32);
	public static BufferedImage BACKGROUNDGAMEOVER = Game.backgroundgameover.getSprite(0, 0, 100, 136);
	
	//Exits
	public static BufferedImage EXIT = Game.exit.getSprite(0, 0, 32, 32);
	public static BufferedImage EXITP = Game.exitP.getSprite(0, 0, 32, 32);
	
	//Plays
	public static BufferedImage PLAY = Game.play.getSprite(0, 0, 64, 64);
	public static BufferedImage PLAYP = Game.playP.getSprite(0, 0, 64, 64);
	
	//Plays
	public static BufferedImage VOLTAR = Game.voltar.getSprite(0, 0, 64, 64);
	public static BufferedImage VOLTARP = Game.voltarP.getSprite(0, 0, 64, 64);
	
	//Botão home
	public static BufferedImage HOME = Game.home.getSprite(0, 0, 32, 32);
	public static BufferedImage HOMEP = Game.homeP.getSprite(0, 0, 32, 32);
	
	//Botão restart
	public static BufferedImage RESTART = Game.restart.getSprite(0, 0, 32, 32);
	public static BufferedImage RESTARTP = Game.restartP.getSprite(0, 0, 32, 32);
	
	//Prédios
	public static BufferedImage PREDIO = Game.cano.getSprite(0, 0, 1024, 2048);
	public static BufferedImage PREDIO2 = Game.cano2.getSprite(0, 0, 1024, 2048);
	
	
}
