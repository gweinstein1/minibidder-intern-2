package com.dstillery.minibidder.util;

/**
 * A version of Runnable that can throw a checked exception.
 * 
 * Primarily intended for use by Utils.unchecked(), but probably
 * useful elsewhere. 
 */
@FunctionalInterface
public interface CheckedRunnable {
	void run() throws Exception;
}
