package com.lix.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class BeanUtils {
	public static Mapper mapper = new DozerBeanMapper();

	public static <T> T copyProperties(Object o, Class<T> targetClass) {
		return (T) mapper.map(o, targetClass);
	}
}
