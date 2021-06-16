package game;

import fixtures.Room;

public class RoomManager {
	
	private Room startingRoom;
	private Room[] rooms;
	
	public void init() {
//		Room foyer = new Room(
//				"The Foyer",
//				"a small foyer",
//				"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
//				+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
//				+ "To the north is a small room, where you can see a piano.");
//				this.rooms[0] = foyer;
//		        this.startingRoom = foyer;
		Room livingRoom = new Room("Living Room", "a living room",
				"It's a living room.");
		this.startingRoom = livingRoom;
		this.rooms[0] = livingRoom;
	}
}
