package oo;

public class Player {
	public int startingLife, time;
	public void spawn() {
		System.out.println("Player Spawned");
	}
	
	public Player(int startingLife, int time) {
		this.startingLife = startingLife;
		this.time  = time;
		System.out.println(startingLife);
		System.out.println(time);
	}
}
