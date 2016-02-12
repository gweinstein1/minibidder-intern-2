package com.dstillery.minibidder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Optional;

import org.junit.Test;

import com.dstillery.minibidder.model.Ad.Size;

public class BidResponseTest {
	
	@Test
	public void testEqualsAndHashcode() throws Exception {
		BidResponse a = new BidResponse(1, Optional.of(new Ad(1, Size._160x600)));
		BidResponse b = new BidResponse(1, Optional.of(new Ad(1, Size._160x600)));
		BidResponse c = new BidResponse(1, Optional.of(new Ad(2, Size._300x250)));
				
		assertEquals(a, b);
		assertNotEquals(b, c);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(b.hashCode(), c.hashCode());
	}

}
