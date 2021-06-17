package fixtures;

import java.util.HashMap;
import java.util.Map;

public class Item extends Fixture {
	
	private int interactionCount = 0;
	private String action;
	private String effectOne;
	private String effectTwo;
	private Map<String,String> uses;
	
	public Item(String name, String shortDescription, String longDescription,
			String action, String effectOne, String effectTwo) {
		super(name, shortDescription, longDescription);
		this.action = action;
		this.effectOne = effectOne;
		this.effectTwo = effectTwo;
		uses = new HashMap<>();
	}

	public String getAction() {
		return action;
	}
	
	public String getEffect() {
		if (++interactionCount == 1) {
			return effectOne;
		} else {
			return effectTwo;
		}
	}
	
	public void putUse(String barrierName, String useDescription) {
		uses.put(barrierName, useDescription);
	}
	
	public Map<String,String> getUses() {
		return uses;
	}
	
}
