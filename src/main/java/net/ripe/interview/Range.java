package net.ripe.interview;

public class Range {

	final int left;
	final int right;
	
	public Range(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public boolean instersects(Range that) {
		if(withinRange(that.left)) {
			return this.right > that.left;
		}
		
		if(withinRange(that.right)) {
			return this.left < that.right;
		}
		
		return this.left > that.left && this.right < that.right;
	}

	private boolean withinRange(int number) {
		return number >= left && number <= right;
	}
	
}
