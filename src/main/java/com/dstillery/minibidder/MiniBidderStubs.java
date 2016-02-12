package com.dstillery.minibidder;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.dstillery.minibidder.bidstrats.ExampleBidStrats;
import com.dstillery.minibidder.filter.brq.BidRequestFilter;
import com.dstillery.minibidder.filter.brq.ExperimentTagBRQFilter;
import com.dstillery.minibidder.filter.campaign.CampaignFilter;
import com.dstillery.minibidder.model.Ad;
import com.dstillery.minibidder.model.BidStrategy;
import com.dstillery.minibidder.model.Campaign;
import com.dstillery.minibidder.model.ExperimentTag;

/**
 * Stubbed-out data model for the minibidder to avoid complications from 
 * working with a db.
 */
public class MiniBidderStubs {
	
	public static final Map<Ad.Size, Set<Campaign>> CAMPAIGNS = 
		Arrays.asList(
			new Campaign(3872, "Acme",               new Ad(1, Ad.Size._160x600), 200, BidStrategy.NO_CHANGE),
			new Campaign(5663, "Sirius Cybernetics", new Ad(2, Ad.Size._300x250), 300, BidStrategy.NO_CHANGE),
			new Campaign(2297, "MomCorp",            new Ad(3, Ad.Size._320x50),  200, ExampleBidStrats.LIKE_COOKIES_THAT_START_WITH_A),
			new Campaign(159,  "Tyrell Corp",        new Ad(4, Ad.Size._728x90),  400, BidStrategy.NO_CHANGE),
			new Campaign(6324, "Globex",             new Ad(5, Ad.Size._300x250), 150, ExampleBidStrats.DOUBLE_OR_NOTHING),
			new Campaign(207,  "Cyberdyne Systems",  new Ad(6, Ad.Size._300x250), 300, BidStrategy.NO_CHANGE)
		).stream()
		 .collect(groupingBy(c -> c.getAd().getSize(), Collectors.toSet()));
	
	private static final List<ExperimentTag> EXPERIMENTS = 
		Arrays.asList(
			new ExperimentTag(1, 0.05),
			new ExperimentTag(2, 0.10),
			new ExperimentTag(3, 0.20)
		);	
			
	public static final List<BidRequestFilter> BRQ_FILTERS = 
		Arrays.asList(
			new ExperimentTagBRQFilter(() -> EXPERIMENTS)
		);
	
	public static final List<CampaignFilter> CAMPAIGN_FILTERS =
		Arrays.asList(
			//A couple of placeholders to kick off type inference 
			(ctx, cam) -> CampaignFilter.Result.INTERESTED,
			(ctx, cam) -> CampaignFilter.Result.INTERESTED
		);
	
			
}
