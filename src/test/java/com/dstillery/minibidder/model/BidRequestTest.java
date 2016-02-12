package com.dstillery.minibidder.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.URI;

import org.junit.Test;

import com.dstillery.minibidder.model.Ad.Size;

public class BidRequestTest {
	
	@Test
	public void testEqualsAndHashcode() throws Exception {
		BidRequest a = new BidRequest(new URI("http://dstillery.com"), "cookie1", Size._160x600);
		BidRequest b = new BidRequest(new URI("http://dstillery.com"), "cookie1", Size._160x600);
		BidRequest c = new BidRequest(new URI("http://dstillery.com"), "cookie2", Size._160x600);
				
		assertEquals(a, b);
		assertNotEquals(b, c);
		
		assertEquals(a.hashCode(), b.hashCode());
		assertNotEquals(b.hashCode(), c.hashCode());
	}

}
