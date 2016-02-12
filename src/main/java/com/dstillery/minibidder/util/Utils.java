package com.dstillery.minibidder.util;

public final class Utils {
	
	public static void unchecked(CheckedRunnable t) {
        try {
            t.run();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <T> T unchecked(CheckedSupplier<T> f) {
        try {
            return f.get();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
	public static int checkPositive(int i) {
		if(i <= 0) {
			throw new IllegalArgumentException("Expected positive value; got "+i);
		}
		return i;
	}
	
	// Utility class, don't instantiate.
	private Utils() {}
}
