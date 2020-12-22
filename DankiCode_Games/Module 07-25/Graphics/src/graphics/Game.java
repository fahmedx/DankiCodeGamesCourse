package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	private final int  WIDTH = 240;
	private final int  HEIGHT = 160;
	private final int SCALE = 3;
	private int x = 0;
	private int frames = 0;
	private int maxframes = 8;
	private int curAnim = 0;
	private int maxAnim = 3;
	
	private BufferedImage img;
	
	private Spritesheet sheet;
	private BufferedImage[] player;
	
	public Game() {
		sheet = new Spritesheet("/spritesheet.png");
		player = new BufferedImage[3];
		player[0] = sheet.getSprite(0, 0, 20, 20);
		player[1] = sheet.getSprite(20, 0, 20, 20);
		player[2] = sheet.getSprite(40, 0, 20, 20);
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		initFrame();
		img = new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
	}
	
	public void initFrame() {
		frame = new JFrame("Pink Pants");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public static void main(String args[]){
		Game game = new Game();
		game.start();
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
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
//		System.out.println("Tick");
		if (x == 240) {
			x = 0;
		}
		x++;
		frames++;
		if (frames > maxframes) {
			frames = 0;
			curAnim++;
			if (curAnim>=maxAnim) {
				curAnim = 0;
			}
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = img.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
//		g.setColor(Color.RED);
//		g.fillOval(20, 20, 15, 15);
		
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		g.setColor(Color.white);
		g.drawString("Pink Pants", 41, 49);
		g.setColor(Color.pink);
		g.drawString("Pink Pants", 40, 50);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.rotate(Math.toRadians(0),90+10,90+10);
		g2.drawImage(player[curAnim], x, 70, null);
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		bs.show();
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta+= (now - lastTime)/ns;
			lastTime = now;
			if (delta >=1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: "+frames);
				frames = 0;
				timer += 1000;
			}
		}
		
		stop();
		
	}

}
