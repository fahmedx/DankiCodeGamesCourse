package game_logic_101;

import java.util.ArrayList;

public class Game implements Runnable{
	private boolean isRunning;
	private Thread thread;
	private ArrayList<Entity> entities = new ArrayList<>();
 	
	public Game() {
		entities.add(new Entity());
		entities.add(new Entity());
		entities.add(new Entity());
		entities.add(new Entity());
		entities.add(new Entity());
		for (int i = 0; i<entities.size(); i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		
	}
	
	public synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void tick() {
		//System.out.println("Tick");
	}
	
	public void render() {
		//System.out.println("Render");
	}
	
	@Override
	public void run() {
		System.out.println("Game Started");
		//Fix 60fps' Amateur's Method
		while(isRunning) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
