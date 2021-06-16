package game;

import fixtures.Item;

public class ItemManager {
	
	private Item[] items = new Item[3];
	
	public void init() {
		Item dog = new Item(
				"Dog",
				"a friendly looking dog",
				"A friendly looking boy is looking up at you. "
				+ "What does it want you to do?",
				"pet",
				"The dog sniffs you then starts wagging its tail.",
				"The good boy loves you!");
		
		Item fridge = new Item(
				"Fridge",
				"a refridgerator",
				"You see a refridgerator displaying some family photos"
				+ " on the front with an assortment of magnets."
				+ " Maybe you can open it?",
				"open",
				"The fridge is empty except for some almond milk. ",
				"The fridge is still empty. Do you have nothing to do?");
		
		Item computerDesk = new Item(
				"Computer Desk",
				"a computer desk",
				"The computer desk is worn out and wooden."
				+ "On top is two monitors and a laptop."
				+ "On the rolling platform is a keyboard and mouse."
				+ "On the floor is a desktop tower."
				+ "Maybe you can use it?",
				"use",
				"You start the video call on the laptop and open STS on the desktop.",
				"Congrats, you're learning Java.");
		
		items[0] = dog;
		items[1] = fridge;
		items[2] = computerDesk;
	}
	
}
