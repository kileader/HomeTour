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
	
	public void setExits(Room[] exits) {
		this.exits = exits;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
		
	public Room getExit(int direction) {
		switch (direction) {
			default:
				return this;
			case 0:
				return exits[0];
			case 1:
				return exits[1];
			case 2:
				return exits[2];
			case 3:
				return exits[3];
		}
	}
}
