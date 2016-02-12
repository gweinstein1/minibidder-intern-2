package com.dstillery.minibidder.filter.brq;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.dstillery.minibidder.model.AuctionContext;
import com.dstillery.minibidder.model.AuctionContext.Key;
import com.dstillery.minibidder.model.BidRequest;
import com.dstillery.minibidder.model.ExperimentTag;
import com.google.common.reflect.TypeToken;

/**
 * This filter is responsible for taking a list of all known experiments and
 * tagging a bid request's AuctionContext with the relevant ones.  A relevant
 * experiment is one whose cookie population should include the cookie from
 * the bid request. 
 */
public class ExperimentTagBRQFilter implements BidRequestFilter {
	
	// The Key used to populate the AuctionContext with the gathered 
	// ExperimentTags.  
	@SuppressWarnings("serial")
	public static final Key<List<ExperimentTag>> EXPERIMENT_TAGS 
		= new Key<>("ExperimentTags", 
				    new TypeToken<List<ExperimentTag>>() {});
	
	private final Supplier<List<ExperimentTag>> experiments;
	
	public ExperimentTagBRQFilter(Supplier<List<ExperimentTag>> experiments) {
		this.experiments = experiments;
	}

	@Override
	public Result test(AuctionContext ctx, BidRequest brq) {
		ctx.set(EXPERIMENT_TAGS, 		
				experiments.get().stream()
					.filter(e -> shouldSample(e, brq))
					.collect(Collectors.toList()));

		return Result.CONTINUE;
	}
	
	private boolean shouldSample(ExperimentTag e, BidRequest brq) {

		// TODO: sampling logic goes here

		return false;
	}

}
