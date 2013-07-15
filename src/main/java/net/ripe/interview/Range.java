package net.ripe.interview;

public class Range {

	private final int left;
	private final int right;
	
	public Range(int left, int right) {
		if(left >= right) {
			throw new IllegalArgumentException("left must be less than right");
		}
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Range)) {
			return false;
		}
		
		Range range = (Range) obj;
		
		return this.left == range.left && this.right == range.right;
		
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 37*result + left;
		result = 37*result + right;
		return result;
	}
	
}
