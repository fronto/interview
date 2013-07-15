package net.ripe.interview;

public class Overlap {

	private final Range first;
	private final Range second;

	public Overlap(Range first, Range second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Overlap)) {
			return false;
		}

		Overlap overlap = (Overlap) obj;

		return overlap.hasRange(first) && overlap.hasRange(second);

	}

	// NB Skipped hashcode deliberately, as ordering of Range elements should not matter,
	// but could unwittingly cause different hashcodes for equivalent ranges if implemented without care

	private boolean hasRange(Range range) {
		return first.equals(range) || second.equals(range);
	}

}
