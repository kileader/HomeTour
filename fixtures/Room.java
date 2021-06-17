package fixtures;

import java.util.HashMap;
import java.util.Map;

public class Room extends Fixture {
	
	private Map<String,Room> exits;
	private Map<String,Item> items;
	private Map<String,Room> blockedExits;
	private Map<String,Barrier> barriers;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		exits = new HashMap<>();
		items = new HashMap<>();
		blockedExits = new HashMap<>();
		barriers = new HashMap<>();
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
	
	public Map<String,Room> getBlockedExits() {
		return blockedExits;
	}
	
	public Room getBlockedExit(String key) {
		return blockedExits.get(key);
	}
	
	public void setBlockedExit(String name, Room exit) {
		blockedExits.put(name, exit);
	}

	public Map<String,Barrier> getBarriers() {
		return barriers;
	}
	
	public Barrier getBarrier(String key) {
		return barriers.get(key);
	}

	public void setBarrier(String name, Barrier barrier) {
		barriers.put(name, barrier);
	}
}
