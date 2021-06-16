package game;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// Game loop: display a prompt, collect input, parse
		
	}
	
	public void printRoom(Player player) {
		// Print a prompt to the console for the player's current room
	}
	
	public String[] collectInput() {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		
		String[] actionAndTarget = line.split("\s+");
		return actionAndTarget;
	}
	
	public void parse(String[] actionAndTarget, Player player) {
		
	}
	
}
