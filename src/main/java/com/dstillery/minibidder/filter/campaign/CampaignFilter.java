package com.dstillery.minibidder.filter.campaign;

import com.dstillery.minibidder.model.AuctionContext;
import com.dstillery.minibidder.model.Campaign;


/**
 * A campaign filter is a check to determine if a Campaign is interested in
 * participating in a given auction. 
 */
@FunctionalInterface
public interface CampaignFilter {
	
	enum Result {
		INTERESTED, NOT_INTERESTED
	}
	
	/**
	 * @param ctx      - The AuctionContext for the current auction.
	 * @param campaign - The campaign to evaluate.
	 * @return NOT_INTERESTED if the campaign is no longer interested in the auction; 
	 *         INTERESTED if the campaign should remain in contention.
	 */
	Result test(AuctionContext ctx, Campaign campaign);
}
