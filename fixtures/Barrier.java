package fixtures;

public class Barrier extends Fixture {
	
	private String clearedDescription;
	private String correctTool;
	private String direction;
	private boolean cleared;
	
	public Barrier(String name, String shortDescription, String longDescription,
			String clearedDescription, String direction, String correctTool) {
		super(name, shortDescription, longDescription);
		this.clearedDescription = clearedDescription;
		this.direction = direction;
		this.correctTool = correctTool;
		cleared = false;
	}

	public String getClearedDescription() {
		return clearedDescription;
	}
	
	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public String getDirection() {
		return direction;
	}
	
	public String getCorrectTool() {
		return correctTool;
	}
	
}
