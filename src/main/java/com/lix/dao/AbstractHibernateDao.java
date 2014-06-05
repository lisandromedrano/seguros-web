package com.lix.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lix.dto.PaginationParams;
import com.lix.dto.Sort;

public abstract class AbstractHibernateDao<T extends Serializable, K extends Serializable>
		implements HibernateDao<T, K> {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(AbstractHibernateDao.class);
	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#setClazz(java.lang.Class)
	 */
	@Override
	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#findOne(long)
	 */
	@Override
	@Transactional
	public T findOne(final K id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#save(T)
	 */
	@Override
	@Transactional
	public void save(final T entity) {
		getCurrentSession().persist(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#update(T)
	 */
	@Override
	@Transactional
	public T update(final T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#delete(T)
	 */
	@Override
	@Transactional
	public void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.vtours.scheduler.dao.HibernateDao#deleteById(long)
	 */
	@Override
	@Transactional
	public void deleteById(final K id) {
		final T entity = findOne(id);
		delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	};

	@Override
	@Transactional
	public List<T> findByQuery(String query) {
		return getCurrentSession().createQuery(query).list();
	}

	/**
	 * Post-Construct method
	 */
	public abstract void setInstance();

	public Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(clazz);
	}

	@Override
	@Transactional
	public List<T> getPage(PaginationParams params) {
		String hql = "from " + clazz.getName();
		if (params.getSorting() != null && params.getSorting().size() > 0) {
			for (Sort s : params.getSorting()) {
				hql += "  r order by r." + s.getProperty() + " "
						+ s.getDirection();
			}
		}
		LOGGER.info("executing query: {} ", hql);
		return getCurrentSession().createQuery(hql)
				.setMaxResults(params.getLimit())
				.setFirstResult(params.getStart()).list();
	}

	/**
	 * @param dto
	 * @return
	 */
	protected Criteria getPaginationCriteria(PaginationParams dto) {
		Criteria criteria = getCriteria();
		return getPaginationCriteria(dto, criteria);
	}

	protected Criteria getPaginationCriteria(PaginationParams dto,
			Criteria criteria) {
		if (dto.getSorting() != null && dto.getSorting().size() > 0) {
			for (Sort sort : dto.getSorting()) {
				String property = sort.getProperty();
				if (PaginationParams.ORDER_ASC.equalsIgnoreCase(sort
						.getDirection())) {
					criteria.addOrder(Order.asc(property));
				} else if (PaginationParams.ORDER_DESC.equalsIgnoreCase(sort
						.getDirection())) {
					criteria.addOrder(Order.desc(property));
				}
			}
		}
		if (dto.getLimit() != null) {
			criteria.setMaxResults(dto.getLimit());
		}
		if (dto.getStart() != null) {
			criteria.setFirstResult(dto.getStart());
		}
		return criteria;
	}

	protected String like(String value) {
		return "%" + value + "%";
	}

	// @Override
	// public SessionFactory getSessionFactory() {
	// return sessionFactory;
	// }
	//
	// @Override
	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }
	@Override
	@Transactional
	public T getOrCreate(T entity, String... fieldsToCompare) {
		Criteria criteria = this.getCriteria();
		T returnEntity = null;
		List<T> list = new ArrayList<T>();
		try {
			String idString = BeanUtils.getProperty(entity, "id");
			if (StringUtils.hasText(idString)) {
				Integer id = Integer.parseInt(idString);
				if (id != null) {
					list = this.getByIdQuery(id);
				}
			}

		} catch (Exception e) {
			LOGGER.info("Could not parse Id, maybe null");
			returnEntity = null;
		}

		if (list.size() > 0) {
			LOGGER.info("Found {} entities by Id", list.size());
			returnEntity = list.get(0);
		} else {
			for (String field : fieldsToCompare) {
				LOGGER.info("Adding criteria for field {}", field);
				if (field.split("\\.").length > 2) {
					LOGGER.info("Nested fields not supported");
					return null;
				} else if (field.split("\\.").length > 1) {
					criteria.createAlias(field.split("\\.")[0],
							field.split("\\.")[0]);
				}
				try {
					String value = BeanUtils.getProperty(entity, field);
					if (StringUtils.hasText(value)) {
						LOGGER.info("Finding {} by {}, value:{}", new String[] {
								getClass().getCanonicalName(), field, value });
						criteria.add(Restrictions.ilike(field, value,
								MatchMode.EXACT));
					} else {
						LOGGER.info("Attribute {} has no value, return null",
								field);
						return null;
					}
				} catch (Exception e) {
					LOGGER.error("Error Getting property {}:{}", field,
							e.getMessage());
				}

			}
			list = (List<T>) criteria.list();
			if (list.size() > 0) {
				LOGGER.info("Found {} entities", list.size());
				returnEntity = list.get(0);
			} else {
				LOGGER.info("Entity " + clazz.getSimpleName() + " created");
				returnEntity = update(entity);

			}
		}
		return returnEntity;
	}

	private List<T> getByIdQuery(Integer id) {
		Query q = getCurrentSession().createQuery(
				"from " + this.clazz.getName() + " where id=:id");
		q.setInteger("id", id);
		return q.list();
	}
}
