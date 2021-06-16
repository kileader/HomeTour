package fixtures;

public abstract class Fixture {
	String name; // a short name or title for the fixture
	String shortDescription; // a one-sentence-long description of a fixture, used to briefly mention the fixture
	String longDescription; // a paragraph-long description of the thing, displayed when the player
							// investigates the fixture thoroughly (looks at it, or enters a room)
	
	Fixture(String name, String shortDescription, String longDescription) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	public String getLongDescription() {
		return longDescription;
	}
		
}