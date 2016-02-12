package com.dstillery.minibidder.exchanges;

import static com.dstillery.minibidder.util.Utils.unchecked;

import java.net.URI;

import spark.Request;
import spark.Response;

import com.dstillery.minibidder.model.Ad;
import com.dstillery.minibidder.model.BidRequest;
import com.dstillery.minibidder.model.BidResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Imaginary exchange that sends simple bid requests in json format.  We 
 * deserialize these (and serialize our responses) with jackson. 
 */
public class AdsRUs implements Exchange {
	
	final ObjectMapper om = new ObjectMapper();
	
	@Override
	public BidRequest parse(Request req) {
		return unchecked(() -> {
			AdsRUsReq parsed = om.readValue(req.body(), AdsRUsReq.class);
			URI uri = new URI(parsed.publisher);
			String[] size = parsed.size.split("x");
			Ad.Size adSize = new Ad.Size(Integer.valueOf(size[0]), 
					                     Integer.valueOf(size[1]));
			return new BidRequest(uri, parsed.cookie, adSize);
		});
	}
	
	@Override
	public String serialize(BidResponse irsp, Response rsp) {
		return unchecked(() -> {
			AdsRUsRsp a = new AdsRUsRsp();
			a.setBid_price(irsp.getBid());
			a.setAd_id(irsp.getAd().map(Ad::getId).orElse(-1));
			return om.writeValueAsString(a);
		});
	}
	
	@SuppressWarnings("unused")
	private static class AdsRUsReq {
		private String publisher;
		private String cookie;
		private String size;
		
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		
		public String getCookie() {
			return cookie;
		}
		public void setCookie(String cookie) {
			this.cookie = cookie;
		}
		
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
	}
	
	@SuppressWarnings("unused")
	private static class AdsRUsRsp {
		private int bid_price;
		private int ad_id;
		
		public int getBid_price() {
			return bid_price;
		}
		public void setBid_price(int bid_price) {
			this.bid_price = bid_price;
		}
		
		public int getAd_id() {
			return ad_id;
		}
		public void setAd_id(int ad_id) {
			this.ad_id = ad_id;
		}
	}
}
