package com.dstillery.minibidder;

import static java.util.Collections.emptySet;
import static spark.Spark.post;
import spark.Request;
import spark.Response;

import com.dstillery.minibidder.exchanges.AdsRUs;
import com.dstillery.minibidder.exchanges.Exchange;
import com.dstillery.minibidder.model.BidRequest;
import com.dstillery.minibidder.model.BidResponse;

/**
 * The entry point for the bidder. Runs standalone, no need to deploy into
 * a container or anything. 
 */
public class Main {	
	
	public static void main(String[] args) {
		
		// If you are unfamiliar with Java 8, code that looks like
		// '() ->', 'arg ->', or '(arg1, arg2) ->', etc, are lambda 
		// statements. You can think of them as concise syntax for an 
		// anonymous class implementing a single-method interface.
		MiniBidder bidder = new MiniBidder(
			() -> MiniBidderStubs.BRQ_FILTERS,
			sz -> MiniBidderStubs.CAMPAIGNS.getOrDefault(sz, emptySet()),
			() -> MiniBidderStubs.CAMPAIGN_FILTERS
		);
				
		Exchange adsRUs = new AdsRUs(); 
		
		post("/ex/ads-r-us", (req, rsp) -> runAuction(bidder, adsRUs, req, rsp));

	}
	
	static String runAuction(MiniBidder bidder, Exchange ex, Request req, Response rsp) {
    	BidRequest breq = ex.parse(req);
    	BidResponse brsp = bidder.runAuction(breq); 
    	return ex.serialize(brsp, rsp);		
	}
		
}
