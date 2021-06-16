package fixtures;

public class Room extends Fixture {
	
	private Room[] exits;
	private Item item;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4]; // 0: North, 1: East, 2: South, 3: West
	}
		
	public Room[] getExits() {
		return exits;
	}
		
	public Room getExit(String direction) {
		switch (direction) {
			default:
				return exits[0]; // TODO Figure this out
			case "north":
				return exits[0];
			case "east":
				return exits[1];
			case "south":
				return exits[2];
			case "west":
				return exits[3];
		}
	}
}
