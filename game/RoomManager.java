package game;

import fixtures.Room;

public class RoomManager {
	
	private Room startingRoom;
	private Room[] rooms;
	
	public RoomManager() {
		rooms = new Room[5];
	}
	
	public void init() {
		
		// Initialize ItemManager and BarrierManager
		ItemManager im = new ItemManager();
		im.init();
		BarrierManager bm = new BarrierManager();
		bm.init();
		
		// Defining room objects
		Room livingRoom = new Room(
				"Living Room", 
				"a spacious living room",
				"The living room has furniture, a TV, and artwork on the walls.\n"
				+ "A dog gets up from a lounging chair and approaches you.\n"
				+ "To the north is the kitchen and dining room.\n"
				+ "To the south is a hallway.");
		livingRoom.setItem("dog", im.getItem("dog"));
		livingRoom.setItem("machete", im.getItem("machete"));
		
		Room kitchenAndDiningRoom = new Room(
				"Kitchen and Dining Room",
				"a kitchen and dining area",
				"The kitchen is seperated from the dining table with a marble countertop.\n"
				+ "In the kitchen there is a refridgerator.\n"
				+ "To the south is a living room");
		kitchenAndDiningRoom.setItem("fridge", im.getItem("fridge"));
		kitchenAndDiningRoom.setItem("key", im.getItem("key"));
				
		Room hallway = new Room(
				"Hallway",
				"a hallway to four rooms",
				"The hallway is to four closed doors.\n"
				+ "Only one door looks... uh... defined.\n"
				+ "On the wall there is a thermostat.");
		hallway.setItem("thermostat", im.getItem("thermostat"));
		hallway.setBarrier("door", bm.getBarrier("door"));
		
		Room bedroom = new Room(
				"Bedroom",
				"a cluttered bedroom",
				"The bedroom looks like a tornado has gone through it.\n"
				+ "It is obviously the most used room in the house.\n"
				+ "In the corner is a computer desk.\n"
				+ "To the east is a hallway.");
		bedroom.setItem("desk", im.getItem("desk"));
		
		// Setting room exits and blocked exits
		livingRoom.setExit("north", kitchenAndDiningRoom);
		livingRoom.setExit("south", hallway);
		
		kitchenAndDiningRoom.setExit("south", livingRoom);
		
		hallway.setExit("north", livingRoom);
		hallway.setBlockedExit("west", bedroom);
		
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
