package game;

import java.util.HashMap;
import java.util.Map;

import fixtures.Barrier;

public class BarrierManager {
	
	private Map<String,Barrier> barriers;
	
	public BarrierManager() {
		barriers = new HashMap<>();
	}
	
	public void init() {
		Barrier door = new Barrier(
				"door",
				"a door with a lock",
				"The door in front of you is made of plywood and painted white.\n"
				+ "There is a bronze colored door knob with a keyhole.\n"
				+ "Maybe you can use something?",
				"The white plywood door is now open.",
				"west",
				"key");
		barriers.put("door", door);
	}
	
	public Barrier getBarrier(String key) {
		return barriers.get(key);
	}
	
}
