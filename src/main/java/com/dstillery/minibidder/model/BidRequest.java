package com.dstillery.minibidder.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;
import java.util.Objects;

/**
 * A BidRequest is our internal model of a bid request, which is a callout from
 * an exchange for an opportunity to bid on an ad slot.  An Exchange
 * implementation is responsible for translating an exchange's specific format
 * into this one.
 * 
 * This is a highly simplified model; for an example of what a real bid request 
 * looks like, check out Google's 
 * <a href="https://developers.google.com/ad-exchange/rtb/downloads/realtime-bidding-proto.txt">protobuf definition</a> 
 * for their bid requests.
 */
public class BidRequest {
	
	private final URI uri;
	private final String cookie;
	private final Ad.Size adSize;
	
	public BidRequest(URI uri, String cookie, Ad.Size adSize) {
		this.uri = checkNotNull(uri);
		this.cookie = checkNotNull(cookie);
		this.adSize = checkNotNull(adSize);
	}
	
	public URI getUri() {
		return uri;
	}

	public String getCookie() {
		return cookie;
	}

	public Ad.Size getAdSize() {
		return adSize;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(uri, cookie, adSize);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof BidRequest)) {
			return false;
		}
		BidRequest that = (BidRequest)o;
		return Objects.equals(this.adSize, that.adSize) &&
			   Objects.equals(this.cookie, that.cookie) &&
			   Objects.equals(this.uri, that.uri);
		
	}
}
