package Reading_Program;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] Args) {
		/*
		Scanner in = new Scanner(System.in);
		String name, age, weight, city, state, country;
		System.out.println("Please, type your name:");
		name = in.nextLine();
		System.out.println("Please, type your age:");
		age = in.nextLine();
		System.out.println("Please, type your weight:");
		weight = in.nextLine();
		System.out.println("Please, type your city:");
		city = in.nextLine();
		System.out.println("Please, type your state:");
		state = in.nextLine();
		System.out.println("Please, type your country:");
		country = in.nextLine();
		//Result
		System.out.println("--------------------------");
		System.out.println("Test Results:");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Weight: " + weight);
		System.out.println("Location: " + city + "-" + state + "/" + country);
		*/
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		String name, command;
		int i, d20;
		i = 1;
		rand.nextInt();
		System.out.println("Hello, please type your name to begin:");
		name = in.nextLine();
		System.out.println("Wellcome "+name);
		while (i == 1) {
			System.out.println("Do you wanna go to witch direction? (w,a,s,d)");
			command	= in.nextLine();
			if(command.equals("w")) {
				System.out.println("You go ahead");
				System.out.println("A enemy aproach, what you gonna do? (a = attack, r=run)");
				command = in.nextLine();
				if (command.equals("a")) {
					d20 = rand.nextInt(20);
					System.out.println("Dice result: "+ d20);
					if (d20>8) {
						System.out.println("You hitted the enemy!");
						System.out.println("Congrats!! You cleared the game");
						i++;
					}else {
						System.out.println("The enemy hitted you, you died...");
						System.out.println("Try Again? (y = Yes, n = No).");
						command = in.nextLine();
						if (command.equals("n")) {
							System.out.println("Thanks for playing.");
							i++;
						}
					}
				} else if (command.equals("r")) {
					System.out.println("You runned, endgame.");
					i++;
				} else {
					System.out.println("Invalid Command, Please Try again...");
				}
			}else if(command.equals("a")) {
				System.out.println("You bumped in a wall.");
				System.out.println("You can see only one way. Straight ahead.");
			}else if (command.equals("s")) {
				System.out.println("You bumped in a wall.");
				System.out.println("You can see only one way. Straight ahead.");
			}else if(command.equals("d")) {
				System.out.println("You bumped in a wall.");
				System.out.println("You can see only one way. Straight ahead.");
			}else {
				System.out.println("Invalid Command, Please Try again...");
			}
		}
	}
}
