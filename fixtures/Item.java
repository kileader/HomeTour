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
	
	public String getEffect() {
		if (++interactionCount == 1) {
			return effectOne;
		} else {
			return effectTwo;
		}
	}
	
	//look at gets long description
}
