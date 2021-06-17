package game;

import fixtures.Item;

public class ItemManager {
	
	private Item[] items = new Item[4];
	
	public void init() {
		Item dog = new Item(
				"Dog",
				"a friendly looking dog",
				"A friendly looking boy is looking up at you.\n"
				+ "What does it want you to do?",
				"pet",
				"The dog sniffs you then starts wagging its tail.",
				"The good boy loves you!");
		
		Item fridge = new Item(
				"Fridge",
				"a plain fridge",
				"You see a refridgerator displaying some family photos\n"
				+ "on the front with an assortment of magnets.\n"
				+ "Maybe you can open it?",
				"open",
				"The fridge is empty except for some almond milk.",
				"The fridge is still empty. Do you have nothing to do?");
		
		Item computerDesk = new Item(
				"Desk",
				"a computer desk",
				"The computer desk is worn out and wooden.\n"
				+ "On top is two monitors and a laptop.\n"
				+ "On the rolling platform is a keyboard and mouse.\n"
				+ "On the floor is a computer tower.\n"
				+ "Maybe you can use it?",
				"use",
				"You start the video call on the laptop and open STS on the desktop.",
				"Congrats, you're learning Java.");
		
		Item thermostat = new Item(
				"Thermostat",
				"a glowing thermostat",
				"The thermostat monitor glows with white text on a purple background.\n"
				+ "Maybe you can use it?",
				"use",
				"You feel hot, so you turn the thermostat down.",
				"You stop and think to yourself. Didn't you just turn it down?");
		
		items[0] = dog;
		items[1] = fridge;
		items[2] = computerDesk;
		items[3] = thermostat;
	}
	
	public Item[] getItems() {
		return items;
	}
	
}
