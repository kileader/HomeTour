package game;

import fixtures.Room;

public class RoomManager {
	
	private Room startingRoom;
	private Room[] rooms = new Room[3];
	
	public void init() {
		Room livingRoom = new Room(
				"Living Room", 
				"a living room",
				"The living room has furniture, a TV, and artwork on the walls. \n"
				+ "A dog gets up from a lounging chair and approaches you. \n"
				+ "To the north is the kitchen and dining room. \n"
				+ "To the south is a hallway and bedrooms. \n");
		this.startingRoom = livingRoom;
		this.rooms[0] = livingRoom;
	}

	public Room getStartingRoom() {
		return startingRoom;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	
}
