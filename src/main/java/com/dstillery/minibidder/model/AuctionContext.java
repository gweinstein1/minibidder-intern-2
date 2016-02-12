package com.dstillery.minibidder.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.common.reflect.TypeToken;

/**
 * The AuctionContext collects metadata from filters defined as part of the 
 * bidding pipeline, for use by later filters or bid strategies.
 */
public class AuctionContext {
	
	private final Map<Key<?>, Object> contextMap = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public <T> T get(Key<T> key){
		return (T) contextMap.get(key);
	}
	
	public <T> void set(Key<T> key, T value) {
		contextMap.put(key, value);
	}
	
	
	/**
	 * Key lets us keep the context api type-safe for users. 
	 */
	public static final class Key<T> {
		public final String name;
		public final TypeToken<T> type;

		public Key(final String nameArg, TypeToken<T> typeArg) {
			name = checkNotNull(nameArg);
			type = checkNotNull(typeArg);
		}
		
		public String getName() {
			return name;
		}

		public TypeToken<T> getType() {
			return type;
		}		

		@Override
		public int hashCode() {
			return Objects.hash(name, type);
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == null || !(o instanceof Key)) {
				return false;
			}
			Key<?> that = (Key<?>)o;
			return Objects.equals(this.name, that.name) &&
				   Objects.equals(this.type, that.type);
		}
	}
}
