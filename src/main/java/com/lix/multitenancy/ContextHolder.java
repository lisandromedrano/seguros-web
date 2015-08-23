package com.lix.multitenancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ContextHolder will hold a reference to a context which can be used
 * through-out the application. The reference will be stored in a
 * <code>ThreadLocal</code>.
 * 
 * @author Marten Deinum
 * @version 1.0
 *
 */
public abstract class ContextHolder {

	private static final Logger logger = LoggerFactory
			.getLogger(ContextHolder.class);
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	public static void setContext(final String context) {
		logger.debug("context set '{}'", context);
		holder.set(context);
	}

	public static String getContext() {
		return holder.get();
	}

	public static void clear() {
		logger.debug("context cleared");
		holder.remove();
	}

}