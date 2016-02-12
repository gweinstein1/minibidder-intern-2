package com.dstillery.minibidder.util;

/**
 * A version of Supplier that can throw a checked exception.
 * 
 * Primarily intended for use by Utils.unchecked(), but probably
 * useful elsewhere. 
 */
@FunctionalInterface
public interface CheckedSupplier<T> {
	T get() throws Exception;
}
