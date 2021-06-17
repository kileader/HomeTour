package game;

import fixtures.Room;

public class RoomManager {
	
	private Room startingRoom;
	private Room[] rooms = new Room[5];
	
	public void init() {
		
		// Initialize ItemManager object
		ItemManager im = new ItemManager();
		im.init();
		
		// Defining room objects
		Room livingRoom = new Room(
				"Living Room", 
				"a spacious living room",
				"The living room has furniture, a TV, and artwork on the walls.\n"
				+ "A dog gets up from a lounging chair and approaches you.\n"
				+ "On a shelf above a fireplace there is a machete.\n"
				+ "To the north is the kitchen and dining room.\n"
				+ "To the south is a hallway.");
		livingRoom.setItem("dog", im.getItem("dog"));
		livingRoom.setItem("machete", im.getItem("machete"));
		
		Room kitchenAndDiningRoom = new Room(
				"Kitchen and Dining Room",
				"a kitchen and dining area",
				"The kitchen is seperated from the dining table with a marble countertop.\n"
				+ "In the kitchen there is a refridgerator.\n"
				+ "On the countertop is a key.\n"
				+ "To the south is a living room");
		kitchenAndDiningRoom.setItem("fridge", im.getItem("fridge"));
		kitchenAndDiningRoom.setItem("key", im.getItem("key"));
				
		Room hallway = new Room(
				"Hallway",
				"a hallway to four rooms",
				"The hallway is to four closed doors.\n"
				+ "Only one door looks... uh... defined.\n"
				+ "On the wall there is a thermostat.\n"
				+ "To the west is a bedroom.");
		hallway.setItem("thermostat", im.getItem("thermostat"));
		hallway.setItem("door", im.getItem("door"));
		
		Room bedroom = new Room(
				"Bedroom",
				"a cluttered bedroom",
				"The bedroom looks like a tornado has gone through it.\n"
				+ "It is obviously the most used room in the house.\n"
				+ "In the corner is a computer desk.\n"
				+ "To the east is a hallway.");
		bedroom.setItem("desk", im.getItem("desk"));
		
		// Setting room exits
		livingRoom.setExit("north", kitchenAndDiningRoom);
		livingRoom.setExit("south", hallway);
		
		kitchenAndDiningRoom.setExit("south", livingRoom);
		
		hallway.setExit("north", livingRoom);
		hallway.setExit("west", bedroom);
		
		bedroom.setExit("east", hallway);
		
		// Setting rooms array and defining starting room
		rooms[0] = livingRoom;
		rooms[1] = kitchenAndDiningRoom;
		rooms[2] = hallway;
		rooms[3] = bedroom;
		this.startingRoom = livingRoom;
	}

	public Room getStartingRoom() {
		return startingRoom;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	
}
