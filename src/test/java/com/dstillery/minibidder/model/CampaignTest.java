package com.dstillery.minibidder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.dstillery.minibidder.model.Ad.Size;

public class CampaignTest {
	
	@Test
	public void testEqualsAndHashcode() {
		Campaign a = new Campaign(1, "1", new Ad(1, Size._160x600), 100, BidStrategy.NO_CHANGE);
		Campaign b = new Campaign(1, "1", new Ad(1, Size._160x600), 100, BidStrategy.NO_CHANGE);
		Campaign c = new Campaign(2, "2", new Ad(2, Size._300x250), 200, BidStrategy.NO_CHANGE);
				
		assertEquals(a, b);
		assertNotEquals(b, c);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(b.hashCode(), c.hashCode());
	}

}
