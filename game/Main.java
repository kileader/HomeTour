package game;

import java.util.Map;
import java.util.Scanner;

import fixtures.Barrier;
import fixtures.Item;
import fixtures.Room;

public class Main {
	
	private static boolean roomPrompt = true;
	
	public static void main(String[] args) {
		
		// Introduction Message
		System.out.println("Welcome to my home tour!\n"
				+ "To use this virtual tour, after every prompt,\n"
				+ "please enter an action word and a target word.\n"
				+ "Example actions: go, inspect, open, keep, use.\n"
				+ "Type show inventory to show your inventory items.\n"
				+ "Type use (item) to use an inventory item.\n"
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
		
		// Display room and items
		System.out.println(cr.getName() + "\n\n"
				+ cr.getLongDescription() + "\n\n"
				+ "Items:\n" + itemShortDescriptions);
		
		// Check if there are barriers
		if (!cr.getBarriers().isEmpty()) {
			// Check for uncleared barriers
			boolean barrierHeading = false;
			for (Map.Entry<String,Barrier> entry : cr.getBarriers().entrySet()) {
				if (!entry.getValue().isCleared()) {
					// Add the Barriers: heading if it isn't there
					if (barrierHeading == false) {
						System.out.println("Barriers:");
						barrierHeading = true;
					}
					// Print barrier name and direction
					System.out.println(entry.getKey() + ": to the " 
							+ entry.getValue().getDirection() + " is " +
							entry.getValue().getShortDescription() + "\n");
				}
			}
		}
	
		String exitShortDescriptions = "";
		Map<String,Room> exits = cr.getExits();
		for (Map.Entry<String,Room> entry : exits.entrySet()) {
			exitShortDescriptions += entry.getKey() + ": "
					+ entry.getValue().getShortDescription() + "\n";
		}
		// Display exits
		System.out.println("Exits:\n" + exitShortDescriptions);
	
	}
	
	public String[] collectInput(Scanner scanner) {
		String line = scanner.nextLine();
		String[] actionAndTarget = line.split("\s+");
		return actionAndTarget;
	}
	
	public void parse(String[] command, Player player) {
		// Check for correct input
		if (command.length != 2) {
			System.out.println("Please only enter two words in lowercase:"
					+ " an action and a target.\n");
			return;
		}
		
		// Define action word and target word from command
		String action = command[0];
		String target = command[1];
		
		// Define current room objects
		Room cr = player.getCurrentRoom();
		Map<String,Item> roomItems = cr.getItems();
		Map<String,Barrier> barriers = cr.getBarriers();
		Map<String,Room> exits = cr.getExits();
		Map<String,Room> blockedExits = cr.getBlockedExits();
		
		// Define player objects
		Map<String,Item> inventory = player.getInventory();
		String focus = player.getFocus();
		
		// Provide long description if command is inspect item in current room
		if (action.equals("inspect") && roomItems.containsKey(target)) {
			System.out.println(roomItems.get(target).getLongDescription() + "\n");
		}
		
		// Provide long description if command is inspect item in inventory
		else if (action.equals("inspect") && inventory.containsKey(target)) {
			System.out.println(inventory.get(target).getLongDescription() + "\n");
		}
		
		// Provide long description and set focus if command is inspect barrier in room
		else if (action.equals("inspect") && barriers.containsKey(target)) {
			if (barriers.get(target).isCleared()) {
				System.out.println(barriers.get(target).getClearedDescription() + "\n");
			} else {
				player.setFocus(target);
				System.out.println(barriers.get(target).getLongDescription() + "\n");
			}
		}
		
		// Add to inventory if command is keep item and the item's action is keep
		else if (action.equals("keep") && roomItems.containsKey(target)
				&& roomItems.get(target).getAction().equals("keep")) {
			inventory.put(target, roomItems.get(target));
			roomItems.remove(target);
			System.out.println(inventory.get(target).getEffect() + "\n");
		}
		
		// Show inventory if the user inputs show inventory
		else if (action.equals("show") && target.equals("inventory")) {
			System.out.println(player.getInventoryShortDescriptions());
		}
		
		// Use a tool on a barrier
		else if (action.equals("use") && inventory.containsKey(target) &&
				inventory.get(target).getUses().containsKey(focus)) {
			// Display using the tool on the barrier
			System.out.println(inventory.get(target).getUse(focus) + "\n");
			// Clear the barrier if it's the correct tool
			if (barriers.get(focus).getCorrectTool().equals(target)) {
				barriers.get(focus).setCleared(true);
				String direction = barriers.get(focus).getDirection();
				Room exitToUnblock = blockedExits.get(direction);
				// Remove blocked exit
				blockedExits.remove(direction);
				// Add exit
				exits.put(direction, exitToUnblock);
				// Room prompt to see opened exit
				roomPrompt = true;
			}
		}
		
		// Provide effect if command is a correct action and item in room
		else if (roomItems.containsKey(target) && 
				action.equals(roomItems.get(target).getAction())) {
			System.out.println(roomItems.get(target).getEffect() + "\n");
		}
		
		// Provide appropriate exit if command is go direction
		else if (action.equals("go") && cr.getExits().containsKey(target)) {
			roomPrompt = true;
			player.setCurrentRoom(exits.get(target));
		}
		
		// Any other case
		else {
			System.out.println("Do what now?\n");
		}
	}
	
}
