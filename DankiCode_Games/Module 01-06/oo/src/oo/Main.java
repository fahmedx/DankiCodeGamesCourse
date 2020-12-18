package oo;

public class Main extends Player{
	private String name = "Fahme";
	private int[] num;
	public static final int MAX_LIFE = 100;
	
	public Main(int n1,int n2) {
		super(n1,n2);
		num = new int[100];
	}
	
	public String getName() {
		return name;
	}
	public static void main(String[] args) {
//		Player plyr = new Player();
//		Player2 plyr2 = new Player2();
//		plyr.spawn();
//		plyr2.spawn2();
		Main m = new Main(100,300);
//		System.out.println(Main.MAX_LIFE);	
	}
}
