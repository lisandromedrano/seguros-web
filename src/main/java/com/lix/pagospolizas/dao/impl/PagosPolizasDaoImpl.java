/*
 * Created on 27 nov 2013 ( Time 15:55:15 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.pagospolizas.dao.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.lix.pagospolizas.model.PagosPolizas;
import com.lix.pagospolizas.dao.PagosPolizasDao;
import com.lix.pagospolizas.dto.PagosPolizasDto;
import com.lix.dao.AbstractHibernateDao;

/**
 * Basic persistence operations for entity "PagosPolizas"
 * 
 *
 * @author Lisandro
 *
 */
@Repository("pagospolizasDao")
public class PagosPolizasDaoImpl extends AbstractHibernateDao<PagosPolizas,Integer> implements PagosPolizasDao{

	@PostConstruct
	public void setInstance() {
		setClazz(PagosPolizas.class);
	}
	@Override
	@Transactional
	public List<PagosPolizas> findByName(String name) {
		Criteria criteria = getCurrentSession().createCriteria((PagosPolizas.class));
		criteria.add(Restrictions.like("name", name.toUpperCase(), MatchMode.ANYWHERE));
		return (List<PagosPolizas>) criteria.list();
	}
	@Override
	@Transactional
	public List<PagosPolizas> find(PagosPolizasDto dto) {
		Criteria criteria = getPaginationCriteria(dto);
		if(dto.getPolizas()!=null && dto.getPolizas().getId()!=null){
			criteria.add(Restrictions.eq("polizas.id", dto.getPolizas().getId()));
		}
		return criteria.list();
	}
}
