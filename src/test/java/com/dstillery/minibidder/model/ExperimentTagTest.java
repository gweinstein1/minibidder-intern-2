package com.dstillery.minibidder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ExperimentTagTest {
	
	@Test
	public void testEqualsAndHashcode() {
		ExperimentTag a = new ExperimentTag(1L, 0.1);
		ExperimentTag b = new ExperimentTag(1L, 0.1);
		ExperimentTag c = new ExperimentTag(2L, 0.2);
				
		assertEquals(a, b);
		assertNotEquals(b, c);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(b.hashCode(), c.hashCode());
	}

}
