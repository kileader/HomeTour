package game;

import java.util.HashMap;
import java.util.Map;

import fixtures.Item;
import fixtures.Room;

public class Player {
	
	private Room currentRoom;
	private Map<String,Item> inventory;
	private String focus;
	
	public Player() {
		inventory = new HashMap<>();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
		focus = null;
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
	
	public String getInventoryShortDescriptions() {
		String inventoryString = "";
		for (Map.Entry<String,Item> entry : inventory.entrySet()) {
			inventoryString += entry.getKey() + ": "
					+ entry.getValue().getShortDescription() + "\n";
		}
		return inventoryString;
	}
	
	public String getFocus() {
		return focus;
	}
	
	public void setFocus(String focus) {
		this.focus = focus;
	}
	
}
