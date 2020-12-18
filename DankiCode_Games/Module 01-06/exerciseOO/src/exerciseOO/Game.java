package exerciseOO;

public class Game {
	private Player player;
	private Enemy enemy;
	public Game() {
		player = new Type1();
		
		if (player == null) {
			System.out.println("Player was not started!");
		}
		if (player instanceof Type1) {
			
			System.out.println("Player started and is well referenced!");
			
		}else if (player instanceof Player) {
			
			System.out.println("Player started and is well referenced!");
			
		}

		enemy = new Enemy();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		Player player = game.getPlayer();
		player.attackEnemy(game.getEnemy());
		System.out.println(game.getEnemy().life);
	}
}
