package com.lix.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.lix.dao.HibernateDao;
import com.lix.dto.PaginationParams;

public abstract class GenericService<T  extends Serializable, K> implements Service<T, K> {
	
	@PostConstruct
	public abstract void setDao();
	
	protected HibernateDao<T,K> dao;
	@Override
	public void save(T entity) {
		dao.save(entity);

	}

	@Override
	public T update(T entity) {
		return dao.update(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);

	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public T getById(K id) {
		return dao.findOne(id);
	}

	@Override
	public void deleteById(K id) {
		dao.deleteById(id);

	}

	@Override
	public List<T> getPage(PaginationParams params) {
		return dao.getPage(params);
	}

}
