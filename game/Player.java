package game;

import java.util.Map;

import fixtures.Item;
import fixtures.Room;

public class Player {
	
	private Room currentRoom;
	private Map<String,Item> inventory;
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public Map<String,Item> getInventory() {
		return inventory;
	}
	
	public Item getItem(String key) {
		return inventory.get(key);
	}
	
	public void addToInventory(String itemName, Item item) {
		inventory.put(itemName, item);
	}
	
}
