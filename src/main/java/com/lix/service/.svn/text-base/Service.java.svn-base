package com.lix.service;

import java.io.Serializable;
import java.util.List;

import com.lix.dto.PaginationParams;

public interface Service<T extends Serializable, K> {

	public abstract void save(T entity);

	public abstract T update(T entity);

	public abstract void delete(T entity);

	public abstract List<T> findAll();

	public abstract T getById(K id);

	public abstract void deleteById(K id);

	public abstract List<T> getPage(PaginationParams params);

}