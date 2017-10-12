package com.lix.util;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

public class CustomHibernateDaoSupport<T> {
	// @Autowired
	protected SessionFactory sessionFactory;

	// @Autowired
	protected HibernateTransactionManager hibernateTemplate;

	@SuppressWarnings("unchecked")
	private Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), CustomHibernateDaoSupport.class);

	// @Autowired
	// public void setSessionFactory0 (SessionFactory sessionFactory){
	// super.setSessionFactory (sessionFactory);
	// }
	// @Autowired
	// public void anyMethodName(SessionFactory sessionFactory)
	// {
	// setSessionFactory(sessionFactory);
	// }
	public void save(T o) {
		sessionFactory.getCurrentSession().save(o);
	}

	public void update(T o) {
		sessionFactory.getCurrentSession().update(o);

	}

	public void delete(T o) {
		sessionFactory.getCurrentSession().delete(o);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Criteria getCriteria() {
		return sessionFactory.getCurrentSession().createCriteria(genericType);
	}
}
