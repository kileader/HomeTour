package game;

import fixtures.Barrier;

public class BarrierManager {
	
	private Barrier[] barriers = new Barrier[1];
	
	public void init() {
		Barrier door = new Barrier(
				"Door",
				"a door with a lock",
				"The door in front of you is made of plywood and painted white.\n"
				+ "There is a bronze colored door knob with a keyhole.",
				"The white plywood door is now open.",
				"key");
		
		barriers[0] = door;
	}
	
	public Barrier[] getBarriers() {
		return barriers;
	}
	
}
