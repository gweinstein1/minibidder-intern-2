package com.dstillery.minibidder.bidstrats;

import java.util.concurrent.ThreadLocalRandom;

import com.dstillery.minibidder.MiniBidder;
import com.dstillery.minibidder.model.BidStrategy;

/**
 * Some (terrible) example bid strategies.
 */
public class ExampleBidStrats {

	public static final BidStrategy BIG_SPENDER = 
		(ctx, bidCents) -> 
			bidCents * 100;
		
	public static final BidStrategy DOUBLE_OR_NOTHING = 
		(ctx, bidCents) -> 
			ThreadLocalRandom.current().nextBoolean() ? 0 : 2 * bidCents;
		
	public static final BidStrategy LIKE_COOKIES_THAT_START_WITH_A =
		(ctx, bidCents) ->
			ctx.get(MiniBidder.BRQ).getCookie().startsWith("a") ? 2 * bidCents
					                                            : bidCents;
}
