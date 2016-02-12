package com.dstillery.minibidder.model;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dstillery.minibidder.model.AuctionContext.Key;
import com.google.common.reflect.TypeToken;

public class AuctionContextTest {
	
	@Test
	public void testTypeTokenOfKey() {
		doTest(new Key<>("String", TypeToken.of(String.class)),
			   "String");
	}
	
	@Test
	@SuppressWarnings("serial")
	public void testKey() {
		doTest(new Key<>("List", new TypeToken<List<String>>(){}),
			   new ArrayList<>());		
	}
	
	private <T> void doTest(Key<T> key, T obj) {
		AuctionContext ctx = new AuctionContext();		
		ctx.set(key, obj);
		T o = ctx.get(key); // Look ma, no casting!
		assertSame(obj, o);		
	}
	
}
