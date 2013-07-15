package net.ripe.interview;

import java.util.ArrayList;
import java.util.List;

public class OverlapFinder {

	public static List<Overlap> findOverlaps(List<Range> ranges) {

		List<Overlap> overlaps = new ArrayList<Overlap>();
		return findOverlapsRecursively(overlaps, ranges);

	}

	private static List<Overlap> findOverlapsRecursively(List<Overlap> overlapsSoFar, List<Range> remainingRanges) {

		if (remainingRanges.size() < 2) {
			return overlapsSoFar;
		}

		Range first = remainingRanges.get(0);

		for (int index = 1; index < remainingRanges.size(); index++) {

			Range next = remainingRanges.get(index);
			if (first.instersects(next)) {
				Overlap overlap = new Overlap(first, next);
				overlapsSoFar.add(overlap);
			}

		}

		remainingRanges = remainingRanges.subList(1, remainingRanges.size());

		return findOverlapsRecursively(overlapsSoFar, remainingRanges);
	}
}
