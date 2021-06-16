package fixtures;

public class Room extends Fixture {
	
	private Room[] exits;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[0]; // size is your choice
	}
		
	public Room[] getExits() {
		return exits;
	}
		
	public Room getExit(String direction) {
		
	}
}
