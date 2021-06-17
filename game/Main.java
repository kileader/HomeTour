package game;

import java.util.Arrays;
import java.util.Scanner;

import fixtures.Item;
import fixtures.Room;

public class Main {
	
	private static boolean promptRoom = true;
	
	public static void main(String[] args) {
		
		// Introduction Message
		System.out.println("Welcome to my home tour!\n"
				+ "To use this virtual tour, after every prompt,\n"
				+ "please enter an action word and a target word.\n"
				+ "Example actions: go, inspect, open, keep\n"
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
			if (promptRoom) {
				main.printRoom(player);
				promptRoom = false;
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
		Room[] exits = cr.getExits();
		
		String exitShortDescriptions = "";
		for (int i = 0; i < 4; i++) {
			if (exits[i].getName() != "Wall") {
				switch (i) {
				case 0:
					exitShortDescriptions += "north: " + exits[0].getShortDescription() + "\n";
					break;
				case 1:
					exitShortDescriptions += "east: " + exits[1].getShortDescription() + "\n";
					break;
				case 2:
					exitShortDescriptions += "south: " + exits[2].getShortDescription() + "\n";
					break;
				case 3:
					exitShortDescriptions += "west: " + exits[3].getShortDescription() + "\n";
					break;
				}
			}
		}
		
		System.out.println(cr.getName() + "\n\n"
				+ cr.getLongDescription() + "\n\n"
				+ "Item:\n"
				+ cr.getItem().getShortDescription() + "\n\n"
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
		Item item = cr.getItem();
		String[] directionsArray = {"north", "east", "south", "west"};
		
		// Provide long description if command is inspect item
		if (command[0].equals("inspect") && 
				command[1].equals(item.getName().toLowerCase())) {
			System.out.println(item.getLongDescription() + "\n");
		} 
		
		// Provide effect if command is the correct action and item
		else if (command[0].equals(item.getAction()) && 
				command[1].equals(item.getName().toLowerCase())) {
			System.out.println(item.getEffect() + "\n");
		} 
		
		// Provide appropriate exit if command is go direction
		else if (command[0].equals("go") && 
				Arrays.asList(directionsArray).contains(command[1])) {
			Room exit = cr;
			
			switch (command[1]) {
			case "north":
				exit = cr.getExit(0);
				break;
			case "east":
				exit = cr.getExit(1);
				break;
			case "south":
				exit = cr.getExit(2);
				break;
			case "west":
				exit = cr.getExit(3);
				break;
			}
			
			if (exit.getName().equals("Wall")) {
				System.out.println("You bump into a wall. Congratulations!\n");
			} else {
				promptRoom = true;
				player.setCurrentRoom(exit);
			}
		} 
		
		else {
			System.out.println("Do what now?\n");
		}
	}
	
}
