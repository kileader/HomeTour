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
				+ "To the north is the kitchen and dining room.\n"
				+ "To the south is a hallway.");
		livingRoom.setItem(im.getItems()[0]); // Add dog item.
		
		Room kitchenAndDiningRoom = new Room(
				"Kitchen and Dining Room",
				"a kitchen and dining area",
				"The kitchen is seperated from the dining table with a marble countertop.\n"
				+ "In the kitchen there is a refridgerator.\n"
				+ "To the south is a living room");
		kitchenAndDiningRoom.setItem(im.getItems()[1]); // Add fridge item.
		
		Room hallway = new Room(
				"Hallway",
				"a hallway to four rooms",
				"The hallway is to four rooms, but only one room looks... uh... defined.\n"
				+ "On the wall there is a thermostat.\n"
				+ "To the west is a bedroom.");
		hallway.setItem(im.getItems()[3]); // Add thermostat item.
		
		Room bedroom = new Room(
				"Bedroom",
				"a cluttered bedroom",
				"The bedroom looks like a tornado has gone through it.\n"
				+ "It is obviously the most used room in the house.\n"
				+ "In the corner is a computer desk.\n"
				+ "To the east is a hallway.");
		bedroom.setItem(im.getItems()[2]); // Add computer desk item.
		
		Room wall = new Room(
				"Wall",
				"a wall",
				"It's a wall.");
		
		
		// Defining room arrays for exits
		Room[] livingRoomExits = {kitchenAndDiningRoom, wall, hallway, wall};
		livingRoom.setExits(livingRoomExits);
		
		Room[] kitchenAndDiningRoomExits = {wall, wall, livingRoom, wall};
		kitchenAndDiningRoom.setExits(kitchenAndDiningRoomExits);
		
		Room[] hallwayExits = {livingRoom, wall, wall, bedroom};
		hallway.setExits(hallwayExits);
		
		Room[] bedroomExits = {wall, hallway, wall, wall};
		bedroom.setExits(bedroomExits);
		
		
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
