package com.dstillery.minibidder.model;

import static com.dstillery.minibidder.util.Utils.checkPositive;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

/**
 * A Campaign represents an ad that we would like to place for our marketer,
 * the price they would like to pay to show it, and a bid strategy that may 
 * adjust that price based on information derived from the bid request.
 */
public class Campaign {

	private final int id;
	private final String description;
	private final Ad ad;
	private final int baseBidCents;
	private final BidStrategy bidStrategy;

	public Campaign(int id,
			        String description, 
			        Ad ad, 
			        int baseBidCents, 
			        BidStrategy bidStrategy) {
		this.id = id;
		this.description = checkNotNull(description);
		this.ad = checkNotNull(ad);
		this.baseBidCents = checkPositive(baseBidCents); 
		this.bidStrategy = checkNotNull(bidStrategy);
	}
	
	public int getId() {
		return id;
	}
		
	public String getDescription() {
		return description;
	}

	public Ad getAd() {
		return ad;
	}

	public int getBaseBidCents() {
		return baseBidCents;
	}
	
	public int getFinalBidCents(AuctionContext ctx) {
		return bidStrategy.adjustBid(ctx, baseBidCents);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description, ad, baseBidCents);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Campaign)) {
			return false;
		}
		Campaign that = (Campaign)o;
		return Objects.equals(this.id, that.id) &&
			   Objects.equals(this.description, that.description) &&
			   Objects.equals(this.ad, that.ad) &&
			   Objects.equals(this.baseBidCents, that.baseBidCents);
	}
	
	
}
