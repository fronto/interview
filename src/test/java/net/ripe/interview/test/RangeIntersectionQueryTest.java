package net.ripe.interview.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.ripe.interview.Range;

import org.junit.Test;

public class RangeIntersectionQueryTest {

	@Test
	public void whenEdgesTouchThereIsNoIntersection() {

		Range untilTwo = new Range(1, 2);
		Range afterTwo = new Range(2, 3);

		assertDoesNotIntersect(untilTwo, afterTwo);

	}

	private void assertDoesNotIntersect(Range untilTwo, Range afterTwo) {
		assertFalse(untilTwo.instersects(afterTwo));
		assertFalse(afterTwo.instersects(untilTwo));
	}

	@Test
	public void whenOneRangeIsContainedInAnotherThereIsAnIntersection() {

		Range oneToFive = new Range(1, 5);
		Range twoToThree = new Range(2, 3);

		assertIntersects(oneToFive, twoToThree);

	}

	private void assertIntersects(Range first, Range second) {
		assertTrue(first.instersects(second));
		assertTrue(second.instersects(first));
	}

	@Test
	public void confirmsSimpleIntersectionWhenItExists() {

		Range oneToThree = new Range(1, 3);
		Range twoToFour = new Range(2, 4);

		assertIntersects(oneToThree, twoToFour);

	}

	@Test
	public void noIntersectionObservedWhenThereIsNone() {

		Range oneToTwo = new Range(1, 2);
		Range fourToFive = new Range(4, 5);

		assertDoesNotIntersect(oneToTwo, fourToFive);

	}
	
	@Test
	public void equivalentRangesIntersect() {
		
		Range oneToTwo = new Range(1,2);
		Range sameAsOneToTwo = new Range(1,2);
		
		assertIntersects(oneToTwo, sameAsOneToTwo);
		
		
	}

}
