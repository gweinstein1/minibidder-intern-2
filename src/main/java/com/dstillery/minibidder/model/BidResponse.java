package com.dstillery.minibidder.model;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Objects;
import java.util.Optional;

/**
 * A BidResponse is the internal model for a bid we might make, which includes
 * a reference to the ad we want to serve and the final price we wish to bid,
 * in cents. It is up to the Exchange implementation we're working with to
 * translate this into an exchange-specific format.
 */
public class BidResponse {
	public static final BidResponse NO_BID 
		= new BidResponse(0, Optional.empty());
	
	private final int bid;
	private final Optional<Ad> ad;
	
	public BidResponse(int bid, Optional<Ad> ad) {
		checkArgument(bid > 0 ? ad.isPresent() : true);
		this.bid = bid;
		this.ad = ad;
	}
	
	public int getBid() {
		return bid;
	}
	
	public Optional<Ad> getAd() {
		return ad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bid, ad);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof BidResponse)) {
			return false;
		}
		BidResponse that = (BidResponse)o;
		return Objects.equals(this.bid, that.bid) &&
			   Objects.equals(this.ad, that.ad);
	}
}
