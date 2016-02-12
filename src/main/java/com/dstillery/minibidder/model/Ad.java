package com.dstillery.minibidder.model;

import static com.dstillery.minibidder.util.Utils.checkPositive;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

/**
 * A simple model for an advertisement.  This assumes the exchange is able to 
 * serve an ad on our behalf based on its id, and we ignore the details of 
 * serving an actual image or ad tag.  The size is included so we can match
 * ad candidates to bidrequests during the auction.
 */
public class Ad {
	
	private final int id;
	private final Size sz;
	
	public Ad(int id, Size sz) {
		this.id = checkPositive(id);
		this.sz = checkNotNull(sz);
	}
	
	public int getId() {
		return id;
	}
	
	public Size getSize() {
		return sz;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, sz);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Ad)) {
			return false;
		}
		Ad that = (Ad)o;
		return Objects.equals(this.id, that.id) &&
			   Objects.equals(this.sz, that.sz);
	}
	
	/**
	 * Size is width x height of an ad slot.
	 */
	public static class Size {
		//Constants for some common ad sizes
		public static final Size _300x250 = new Size(300, 250);
		public static final Size _728x90  = new Size(728, 90);
		public static final Size _160x600 = new Size(160, 600);
		public static final Size _320x50  = new Size(320, 50);
		
		private final int width;
		private final int height;
		public Size(int width, int height) {
			this.width = width;
			this.height = height;
		}
		public int getHeight() {
			return height;
		}
		public int getWidth() {
			return width;
		}
		@Override
		public int hashCode() {
			return Objects.hash(width, height);
		}
		@Override
		public boolean equals(Object o) {
			if(o == null || !(o instanceof Size)) {
				return false;
			}
			Size that = (Size)o;
			return Objects.equals(this.width, that.width) &&
				   Objects.equals(this.height, that.height);
		}
	}

}
