package com.lix.dao;

import java.io.Serializable;
import java.util.List;

import com.lix.dto.PaginationParams;

public interface HibernateDao<T extends Serializable, K> {

	public abstract void setClazz(final Class<T> clazzToSet);

	public abstract T findOne(K id);

	public abstract List<T> findAll();

	public abstract List<T> findByQuery(String query);

	public abstract void save(final T entity);

	public abstract void saveOrUpdate(final T entity);

	public abstract T update(final T entity);

	public abstract void delete(final T entity);

	public abstract void deleteById(final K id);

	public abstract List<T> getPage(PaginationParams params);

	// public <D> Page<D> findPage(PaginationParams dto, Class<D> dtoClass);

	public T getOrCreate(T entity, String... fieldsToCompare);

}