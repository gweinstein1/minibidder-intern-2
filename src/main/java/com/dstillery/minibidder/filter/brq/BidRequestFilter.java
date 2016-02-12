package com.dstillery.minibidder.filter.brq;

import com.dstillery.minibidder.model.AuctionContext;
import com.dstillery.minibidder.model.BidRequest;

/**
 * A BidRequestFilter is a check to determine if the auction should continue
 * or if the bid request should be rejected with a no-bid. It may also populate
 * the AuctionContext for use by later filters or bid strategies.
 */
@FunctionalInterface
public interface BidRequestFilter {
	
	enum Result {
		CONTINUE, NO_BID
	}
	
	/**
	 * @param ctx - The AuctionContext for the current auction.
	 * @param brq - The BidRequest to evaluate.
	 * @return false if the bidrequest should be rejected; 
	 *         true if the auction should continue.
	 */
	Result test(AuctionContext ctx, BidRequest brq);
}
