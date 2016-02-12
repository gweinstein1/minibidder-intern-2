package com.dstillery.minibidder.exchanges;

import com.dstillery.minibidder.model.BidRequest;
import com.dstillery.minibidder.model.BidResponse;

import spark.Request;
import spark.Response;

/**
 * Simple interface for exchange integrations.  Intent is that we parse the
 * partner request into our internal model, and serialize our internal response
 * model into the response the exchange expects.
 */
public interface Exchange {

	BidRequest parse(Request req);
	
	String serialize(BidResponse irsp, Response rsp);
}
