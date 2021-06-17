package game;

import java.util.Map;
import java.util.Scanner;

import fixtures.Item;
import fixtures.Room;

public class Main {
	
	private static boolean roomPrompt = true;
	
	public static void main(String[] args) {
		
		// Introduction Message
		System.out.println("Welcome to my home tour!\n"
				+ "To use this virtual tour, after every prompt,\n"
				+ "please enter an action word and a target word.\n"
				+ "Example actions: go, inspect, open, keep, use\n"
				+ "Type quit to quit\n");
		
		// Initiate classes
		Main main = new Main();
		Player player = new Player();
		RoomManager rm = new RoomManager();
		Scanner scanner = new Scanner(System.in);
		
		// Initiate data
		rm.init();
		player.setCurrentRoom(rm.getStartingRoom());
		
		// Game loop: display a prompt, collect input, parse
		gameLoop: while(true) {
			
			// Display a prompt
			if (roomPrompt) {
				main.printRoom(player);
				roomPrompt = false;
			}
			
			// Collect input
			String[] command = main.collectInput(scanner);
			
			// Check for quit keyword
			if (command[0].equals("quit")) {
				break gameLoop;
			}
			
			// Parse the input
			main.parse(command, player);
		}
		// Close up
		System.out.println("Goodbye.");
		scanner.close();
	}
	
	public void printRoom(Player player) {
		Room cr = player.getCurrentRoom();
		
		String itemShortDescriptions = "";
		Map<String,Item> items = cr.getItems();
		for (Map.Entry<String,Item> entry : items.entrySet()) {
			itemShortDescriptions += entry.getKey() + ": "
					+ entry.getValue().getShortDescription() + "\n";
		}
		
		String exitShortDescriptions = "";
		Map<String,Room> exits = cr.getExits();
		for (Map.Entry<String,Room> entry : exits.entrySet()) {
			exitShortDescriptions += entry.getKey() + ": "
					+ entry.getValue().getShortDescription() + "\n";
		}
		
//		for (int i = 0; i < 4; i++) {
//			if (exits[i].getName() != "Wall") {
//				switch (i) {
//				case 0:
//					exitShortDescriptions += "north: " + exits[0].getShortDescription() + "\n";
//					break;
//				case 1:
//					exitShortDescriptions += "east: " + exits[1].getShortDescription() + "\n";
//					break;
//				case 2:
//					exitShortDescriptions += "south: " + exits[2].getShortDescription() + "\n";
//					break;
//				case 3:
//					exitShortDescriptions += "west: " + exits[3].getShortDescription() + "\n";
//					break;
//				}
//			}
//		}
		
		System.out.println(cr.getName() + "\n\n"
				+ cr.getLongDescription() + "\n\n"
				+ "Items:\n"
				+ itemShortDescriptions + "\n"
				+ "Exits:\n"
				+ exitShortDescriptions);
	}
	
	public String[] collectInput(Scanner scanner) {
		String line = scanner.nextLine();
		String[] actionAndTarget = line.split("\s+");
		return actionAndTarget;
	}
	
	public void parse(String[] command, Player player) {
		// Check for correct input
		if (command.length != 2) {
			System.out.println("Please only enter two words in lowercase. An action and a target.");
			return;
		}
		
		// Initialize variables
		Room cr = player.getCurrentRoom();
		String action = command[0];
		String target = command[1];
		
		// Provide long description if command is inspect item in current room
		if (action.equals("inspect") && cr.getItems().containsKey(target)) {
			System.out.println(cr.getItem(target).getLongDescription() + "\n");
		}
		
		// Provide long description if command is inspect item in inventory
		else if (action.equals("inspect") && player.getInventory().containsKey(target)) {
			System.out.println(player.getItem(target).getLongDescription() + "\n");
		}
		
		// Add to inventory if command is keep item and the item's action is keep
		else if (action.equals("keep") && cr.getItems().containsKey(target)
				&& cr.getItem(target).getAction().equals("keep")) {
			player.addToInventory(target, cr.getItem(target));
			cr.getItems().remove(target);
			System.out.println(cr.getItem(target).getEffect());
		}
		
		// Provide effect if command is a correct action and item in room
		else if (cr.getItems().containsKey(target) && 
				action.equals(cr.getItem(target).getAction())) {
			System.out.println(cr.getItem(target).getEffect() + "\n");
		}
		
//		// Provide effect if command is use and item is in inventory
//		else if (player.getInventory().containsKey(target) &&
//				action.equals(player.getItem(target).getAction())) {
//			System.out.println(player.getItem(target).getEffect() + "\n");
//		}
		
		// Provide appropriate exit if command is go direction
		else if (action.equals("go") && cr.getExits().containsKey(target)) {
			roomPrompt = true;
			player.setCurrentRoom(cr.getExit(target));
		}
		
		else {
			System.out.println("Do what now?\n");
		}
	}
	
}
