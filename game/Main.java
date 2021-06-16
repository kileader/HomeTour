package game;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		// Initiate classes
		Main main = new Main();
		Player player = new Player();
		RoomManager rm = new RoomManager();
		ItemManager im = new ItemManager();
		
		// Initiate data
		rm.init();
		im.init();
		
		// Set starting room
		player.setCurrentRoom(rm.getStartingRoom());
		
		// Game loop: display a prompt, collect input, parse
		while(true) {
			main.printRoom(player);
			
		}
		
	}
	
	public void printRoom(Player player) {
		player.getCurrentRoom();
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
