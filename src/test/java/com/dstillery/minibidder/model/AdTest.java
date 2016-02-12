package com.dstillery.minibidder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.dstillery.minibidder.model.Ad.Size;

public class AdTest {
	
	@Test
	public void testEqualsAndHashcode() {
		Ad a = new Ad(1, Size._160x600);
		Ad b = new Ad(1, Size._160x600);
		Ad c = new Ad(2, Size._300x250);
				
		assertEquals(a, b);
		assertNotEquals(b, c);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(b.hashCode(), c.hashCode());
	}

}
