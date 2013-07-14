package net.ripe.interview.test;

import java.util.Arrays;
import java.util.List;

import net.ripe.interview.Overlap;
import net.ripe.interview.OverlapFinder;
import net.ripe.interview.Range;

import org.junit.Test;
import static org.junit.Assert.*;

public class FindOvelapsTest {

	// @Test
	// public void doesNotOverlapWhenRangesTouchButDoNotIntersect() {
	//
	// }

	@Test
	public void findsSimpleOverlap() {

		Range first = new Range(1, 3);
		Range second = new Range(2, 5);

		Overlap expected = new Overlap(first, second);

		List<Overlap> result = OverlapFinder.findOverlaps(Arrays.asList(first, second));
		assertTrue(result.contains(expected));

	}

	// @Test
	// public void doesNotReturnDuplicateOverlaps() {
	//
	// }
	//
	// @Test
	// public void returnsOverlapWhenOneRangeContainsAnother() {
	//
	// }

}
