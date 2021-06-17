package game;

import java.util.ArrayList;

import fixtures.Item;
import fixtures.Room;

public class Player {
	
	private Room currentRoom;
	private ArrayList<Item> inventory;
	
	public Player() {
		inventory = new ArrayList<>();
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void addToInventory(Item item) {
		inventory.add(item);
	}
	
}
