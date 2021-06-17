package fixtures;

import java.util.HashMap;
import java.util.Map;

public class Room extends Fixture {
	
	private Map<String,Room> exits;
	private Map<String,Item> items;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		exits = new HashMap<>();
		items = new HashMap<>();
	}
	
	public Room getExit(String direction) {
		return exits.get(direction);
	}
	
	public Map<String,Room> getExits() {
		return exits;
	}
	
	public void setExit(String direction, Room exit) {
		exits.put(direction, exit);
	}
	
	public Item getItem(String key) {
		return items.get(key);
	}
	
	public Map<String,Item> getItems() {
		return items;
	}
	
	public void setItem(String name, Item item) {
		items.put(name, item);
	}
}
