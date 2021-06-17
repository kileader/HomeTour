package fixtures;

public class Barrier extends Fixture {
	
	private String clearedDescription;
	private String correctTool;
	private boolean cleared;
	
	public Barrier(String name, String shortDescription, String longDescription,
			String clearedDescription, String correctTool) {
		super(name, shortDescription, longDescription);
		this.clearedDescription = clearedDescription;
		this.correctTool = correctTool;
		cleared = false;
	}

	public String getClearedDescription() {
		return clearedDescription;
	}
	
	public boolean isCleared() {
		return cleared;
	}

	public void clearBarrier(String itemName) {
		if (itemName.equals(correctTool)) {
			cleared = true;
		}
	}

	
	
}
