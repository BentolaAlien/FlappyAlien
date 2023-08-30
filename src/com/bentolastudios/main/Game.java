package com.bentolastudios.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import com.bentolastudios.entities.Entity;
import com.bentolastudios.entities.Player;
import com.bentolastudios.graficos.Sprites;
import com.bentolastudios.graficos.Spritesheet;
import com.bentolastudios.graficos.UI;

import com.bentolastudios.world.PredioGenerator;
import com.bentolastudios.world.PredioGeneratoriz;
import com.bentolastudios.world.World;



public class Game extends Canvas implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	
	//criar janela
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public static final int WIDTH = 180;
	public static final int HEIGHT = 320;
	public static final int SCALE = 2;

	private BufferedImage image;

	//sprites
	public static List<Entity> entities;
	public static Spritesheet spritesheet;
	public static Spritesheet titulo;
	public static Spritesheet dificuldadeN;
	public static Spritesheet background;
	public static Spritesheet backgroundhard;
	public static Spritesheet backgroundmenu;
	public static Spritesheet backgroundgameover;
	public static Spritesheet gameover;
	public static Spritesheet cano;
	public static Spritesheet cano2;
	public static Spritesheet voltar;
	public static Spritesheet voltarP;
	public static Spritesheet exit;
	public static Spritesheet exitP;
	public static Spritesheet play;
	public static Spritesheet playP;
	public static Spritesheet home;
	public static Spritesheet homeP;
	public static Spritesheet restart;
	public static Spritesheet restartP;
	public static Spritesheet creditos;
	public static Spritesheet sprites;
	
	//onde vai começar
	public static String gameState = "MENU";
	private boolean RestartGame = false;

	//cutscene
	public static int entrada = 1;
	public static int começar = 2;
	public static int jogando = 3;
	public static int acabando = 4;
	public static int estado_cena = entrada;
	
	public int timeCena = 0, maxTimeCena = 5;
	
	//instanciando
	public static Player player;
	public static PredioGenerator prediogenerator;
	public static PredioGeneratoriz prediogeneratoriz;
	public UI ui;
	
	//score
	public static double score = 0;
	
	//menus
	
	public Menu menu;
	public Difficulty dificuldade;
	public GameOverMenu gameovermenu;
	public GameOverMenuiz gameovermenuiz;
	public Creditos credito;

	public Game() {
		
		Sound.menuBackground.play();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		// Inicializando sprite
		spritesheet = new Spritesheet("/spritesheet.png");
		titulo = new Spritesheet("/titulo.png");
		dificuldadeN = new Spritesheet("/dificuldade.png");
		background = new Spritesheet("/background.png");
		backgroundhard = new Spritesheet("/backgroundhard.png");
		backgroundmenu = new Spritesheet("/BackgroundMenu.png");
		backgroundgameover = new Spritesheet("/backgroundGameOver.png");
		gameover = new Spritesheet("/GameOver.png");
		cano = new Spritesheet("/cano.png");
		cano2 = new Spritesheet("/cano2.png");
		voltar = new Spritesheet("/voltar.png");
		voltarP = new Spritesheet("/voltarP.png");
		play = new Spritesheet("/play.png");
		playP = new Spritesheet("/playP.png");
		exit = new Spritesheet("/exit.png");
		exitP = new Spritesheet("/exitP.png");
		home = new Spritesheet("/home.png");
		homeP = new Spritesheet("/homeP.png");
		restart = new Spritesheet("/restart.png");
		restartP = new Spritesheet("/restartP.png");
		creditos = new Spritesheet("/creditos.png");
		sprites = new Spritesheet("");
		
		// Inicializando objetos
		entities = new ArrayList<Entity>();
		player = new Player(WIDTH / 2 - 90, HEIGHT / 2 - 80, 25, 25, 2, spritesheet.getSprite(0, 0, 32, 32));
		prediogenerator = new PredioGenerator();
		prediogeneratoriz = new PredioGeneratoriz();
		ui = new UI();
		gameovermenu = new GameOverMenu();
		gameovermenuiz = new GameOverMenuiz();
		entities.add(player);
		dificuldade = new Difficulty();
		credito = new Creditos();
		menu = new Menu();
	
	}
	//configurações janelas
	public void initFrame() {
		frame = new JFrame("Flappy Alien");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}

	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.start();
	}
	
	//ações
	public void tick() {

		if (gameState == "MENU") {
			
			menu.tick();
		}if (gameState == "CREDITO") {
			
			credito.tick();
		}if (gameState == "DIFICULDADE") {
			
			dificuldade.tick();
		}
		if (gameState == "RUNNING") {
			Sound.menuBackground.stop();
			this.RestartGame = false;
			prediogenerator.tick();
			if (Game.estado_cena == Game.jogando) {
				for (int i = 0; i < entities.size(); i++) {
					Entity e = entities.get(i);
					e.tick();
				}
			} else {
				if (Game.estado_cena == Game.entrada) {
					if (player.getX() < 50) {
						player.x++;
						player.y += 1;
					} else {
						Game.estado_cena = Game.começar;
					}
				} else if (Game.estado_cena == Game.começar) {
					timeCena++;
					if (timeCena == maxTimeCena) {
						Game.estado_cena = Game.jogando;
						timeCena++;
					}
				}
			}
		} else if (gameState == "GAME_OVER") {
			gameovermenu.tick();
			if (RestartGame) {
				this.RestartGame = false;
				Game.gameState = "RUNNING";
				World.restartGame();
			}
		}
		
		if (gameState == "RUNNINGIZ") {
			Sound.menuBackground.stop();
			this.RestartGame = false;
			prediogeneratoriz.tick();
			if (Game.estado_cena == Game.jogando) {
				for (int i = 0; i < entities.size(); i++) {
					Entity e = entities.get(i);
					e.tick();
				}
			} else {
				if (Game.estado_cena == Game.entrada) {
					if (player.getX() < 50) {
						player.x++;
						player.y += 1;
					} else {
						Game.estado_cena = Game.começar;
					}
				} else if (Game.estado_cena == Game.começar) {
					timeCena++;
					if (timeCena == maxTimeCena) {
						Game.estado_cena = Game.jogando;
						timeCena++;
					}
				}
			}
		}else if (gameState == "GAME_OVERIZ") {
			gameovermenuiz.tick();
			if (RestartGame) {
				this.RestartGame = false;
				Game.gameState = "RUNNINGIZ";
				World.restartGame();
			}
		}
	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = image.getGraphics();
		// Renderizando Background
		if(gameState == "RUNNINGIZ")
		g.drawImage(Sprites.BACKGROUND, 0, 0, WIDTH, HEIGHT, null);

		if(gameState == "RUNNING")
			g.drawImage(Sprites.BACKGROUNDHARD, 0, 0, WIDTH, HEIGHT, null);
			
		// Renderizando Jogo
		Collections.sort(entities, Entity.nodeSorter);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}

		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		ui.render(g);
		if (gameState == "GAME_OVER") {
			gameovermenu.render(g);
		} else if (gameState == "GAME_OVERIZ") {
			gameovermenuiz.render(g);
		} else if (gameState == "MENU") {
			menu.render(g);
		}else if(gameState == "CREDITO") {
			credito.render(g);
		} else if(gameState == "DIFICULDADE") {
			dificuldade.render(g);
		}
		bs.show();
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				frames++;
				delta--;

			}

			if (System.currentTimeMillis() - timer >= 1000) {

				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
				frames = Frames();
			}

		}

		stop();
	}

	private int Frames() {

		return 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_N) {
			Sound.musicIZ.play();
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			Sound.musicIZ.stop();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.isPressed = true;
			if (gameState == "MENU") {
				menu.up = true;
			}
			if (gameState == "DIFICULDADE") {
				dificuldade.up = true;	
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (gameState == "MENU") {
				menu.enter = true;
			}
			if (gameState == "DIFICULDADE") {
				dificuldade.enter = true;	
			}
		}

		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (gameState == "GAME_OVER") {
				gameovermenu.enter = true;
			}if (gameState == "GAME_OVERIZ") {
				gameovermenuiz.enter = true;
			}if (gameState == "CREDITO") {
				credito.enter = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (gameState == "MENU") {
				menu.down = true;	
			}
			if (gameState == "DIFICULDADE") {
				dificuldade.down = true;	
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			if (gameState == "GAME_OVER") {
				gameovermenu.right = true;
			}if (gameState == "GAME_OVERIZ") {
				gameovermenuiz.right = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (gameState == "GAME_OVER") {
				gameovermenu.left = true;
			}if (gameState == "GAME_OVERIZ") {
				gameovermenuiz.left = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.isPressed = false;
			if (gameState == "MENU") {
				menu.up = false;
			}
			if (gameState == "DIFICULDADE") {
				dificuldade.up = false;	
			}}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				if (gameState == "GAME_OVER") {
					gameovermenu.right = false;
				}
				if (gameState == "GAME_OVERIZ") {
					gameovermenuiz.right = false;
				}
			}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (gameState == "MENU") {
				menu.down = false;
			}
			if (gameState == "DIFICULDADE") {
				dificuldade.down = false;	
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			if (gameState == "GAME_OVER") {
				gameovermenu.left = false;
			}			if (gameState == "GAME_OVERIZ") {
				gameovermenuiz.left = false;
			}
		}

	}

	public void keyTyped(KeyEvent e) {

	}

	public void mouseClicked(MouseEvent m) {

			
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent arg0) {

	}

	public void mouseDragged(MouseEvent arg0) {

	}

	public void mouseMoved(MouseEvent e) {

	}

}
