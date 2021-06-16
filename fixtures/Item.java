package fixtures;

public class Item extends Fixture {
	
	private static int interactionCount = 0;
	private String action;
	private String effectOne;
	private String effectTwo;
	
	public Item(String name, String shortDescription, String longDescription,
			String action, String effectOne, String effectTwo) {
		super(name, shortDescription, longDescription);
	}

	public String getAction() {
		return action;
	}

	public String getEffectOne() {
		return effectOne;
	}

	public String getEffectTwo() {
		return effectTwo;
	}
	
	public void interact() {
		interactionCount++;
	}
	
	//look at gets long description
}
