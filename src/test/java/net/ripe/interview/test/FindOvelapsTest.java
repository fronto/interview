package net.ripe.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import net.ripe.interview.Overlap;
import net.ripe.interview.OverlapFinder;
import net.ripe.interview.Range;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

public class FindOvelapsTest {

	private static final int ONE = 1;

	@Test
	public void doesNotOverlapWhenRangesTouchButDoNotIntersect() {

		Range oneToTwo = new Range(1, 2);
		Range twoToFour = new Range(2, 4);

		assertThat(overlapsFrom(oneToTwo, twoToFour), isEmpty());

	}

	private Matcher<List<Overlap>> isEmpty() {
		return new CustomTypeSafeMatcher<List<Overlap>>("should be empty") {

			@Override
			protected boolean matchesSafely(List<Overlap> item) {
				return item.isEmpty();
			}
		};

	}

	private List<Overlap> overlapsFrom(Range... ranges) {

		return OverlapFinder.findOverlaps(Arrays.asList(ranges));

	}

	@Test
	public void findsSimpleOverlap() {

		Range first = new Range(1, 3);
		Range second = new Range(2, 5);

		Overlap expected = new Overlap(first, second);

		assertTrue(overlapsFrom(first, second).contains(expected));

	}

	@Test
	public void doesNotOverlapWhenRangesDoNotIntersect() {

		Range first = new Range(1, 2);
		Range second = new Range(3, 5);

		assertThat(overlapsFrom(first, second), isEmpty());

	}

	@Test
	public void doesNotReturnDuplicateOverlaps() {
		Range first = new Range(1, 3);
		Range second = new Range(2, 5);
		Range doesNotOverlap = new Range(7, 9);

		List<Overlap> result = overlapsFrom(first, second, doesNotOverlap);
		assertEquals(ONE, result.size());

	}

	@Test
	public void returnsOverlapWhenOneRangeContainsAnother() {

		Range inner = new Range(2, 3);
		Range outer = new Range(1, 4);

		Overlap expected = new Overlap(inner, outer);

		assertTrue(overlapsFrom(inner, outer).contains(expected));

	}

}
