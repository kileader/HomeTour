package game;

import java.util.HashMap;
import java.util.Map;

import fixtures.Item;

public class ItemManager {
	
	private Map<String,Item> items;
	
	public ItemManager() {
		items = new HashMap<>();
	}
	
	public void init() {
		
		Item dog = new Item(
				"Dog",
				"a friendly looking dog",
				"A friendly looking boy is looking up at you.\n"
				+ "What does it want you to do?",
				"pet",
				"The dog sniffs you then starts wagging its tail.",
				"The good boy loves you!");
		items.put("dog", dog);
		
		Item fridge = new Item(
				"Fridge",
				"a plain fridge",
				"You see a refridgerator displaying some family photos\n"
				+ "on the front with an assortment of magnets.\n"
				+ "Maybe you can open it?",
				"open",
				"The fridge is pretty much empty.",
				"The fridge is still empty. Do you have nothing to do?");
		items.put("fridge", fridge);
		
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
		items.put("desk", computerDesk);
		
		Item thermostat = new Item(
				"Thermostat",
				"a glowing thermostat",
				"The thermostat monitor glows with white text on a purple background.\n"
				+ "Maybe you can use it?",
				"use",
				"You feel hot, so you turn the thermostat down.",
				"You stop and think to yourself. Didn't you just turn it down?");
		items.put("thermostat", thermostat);
		
		Item machete = new Item(
				"Machete",
				"a decorative machete in its sheath",
				"You pick up the machete and notice that the sheath\n"
				+ "and handle are made of intricately carved wood. You take the blade\n"
				+ "out and see that the blade is old but sharp, then put it back.",
				"keep",
				"You carry the machete with you. Please don't cut anything.",
				"You are already keeping the machete.");
		items.put("machete", machete);
		machete.putUse("door", "You slash up the door, but it doesn't open.");
		
		Item key = new Item(
				"Key",
				"a bronze key",
				"You look at the key, and it seems very keylike.\n"
				+ "It's almost as if you know it will unlock something.",
				"keep",
				"You carry the key with you in your inventory.",
				"You are already keeping the key.");
		items.put("key", key);
		key.putUse("door", "You put the key into the lock. It fits!\n"
				+ "You unlock the door!");
		
	}
	
	public Item getItem(String key) {
		return items.get(key);
	}
	
}
