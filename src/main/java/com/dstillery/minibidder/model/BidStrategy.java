package com.dstillery.minibidder.model;

/**
 * Represents a strategy for adjusting bid prices based on
 * the state of the current auction.  
 */
@FunctionalInterface
public interface BidStrategy {
		
	/**
	 * @param  ctx - the context for the current auction
	 * @param  bid - the previous bid, in cents
	 * @return the strategy-adjusted bid, in cents
	 */
	int adjustBid(AuctionContext ctx, int bidCents);
	
	final BidStrategy NO_CHANGE = (ctx, bidCents) -> bidCents;
	final BidStrategy BID_ZERO = (ctx, bidCents) -> 0;
}
