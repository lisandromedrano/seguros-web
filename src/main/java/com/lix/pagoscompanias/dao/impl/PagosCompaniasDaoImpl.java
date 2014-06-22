/*
 * Created on 27 nov 2013 ( Time 16:23:16 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.pagoscompanias.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lix.dao.AbstractHibernateDao;
import com.lix.pagoscompanias.dao.PagosCompaniasDao;
import com.lix.pagoscompanias.dto.PagosCompaniasDto;
import com.lix.pagoscompanias.model.PagosCompanias;
import com.lix.util.BeanUtils;
import com.lix.web.Page;

/**
 * Basic persistence operations for entity "PagosCompanias"
 * 
 * 
 * @author Lisandro
 * 
 */
@Repository("pagoscompaniasDao")
public class PagosCompaniasDaoImpl extends
		AbstractHibernateDao<PagosCompanias, Integer> implements
		PagosCompaniasDao {

	@PostConstruct
	public void setInstance() {
		setClazz(PagosCompanias.class);
	}

	@Override
	@Transactional
	public List<PagosCompanias> findByName(String name) {
		Criteria criteria = getCurrentSession().createCriteria(
				(PagosCompanias.class));
		criteria.add(Restrictions.like("name", name.toUpperCase(),
				MatchMode.ANYWHERE));
		return (List<PagosCompanias>) criteria.list();
	}

	@Override
	public List<PagosCompanias> findByCompania(Integer idCompania) {
		Criteria criteria = getCurrentSession().createCriteria(
				(PagosCompanias.class));
		criteria.add(Restrictions.eq("companias.id", idCompania));
		return (List<PagosCompanias>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PagosCompanias> find(PagosCompaniasDto dto) {
		Criteria criteria = getPaginationCriteria(dto);
		if (dto.getCompanias() != null && dto.getCompanias().getId() != null) {
			criteria.add(Restrictions.eq("companias.id", dto.getCompanias()
					.getId()));
		}
		return criteria.list();
	}

	@Override
	public Page<PagosCompaniasDto> findPage(PagosCompaniasDto dto) {
		Page<PagosCompaniasDto> page = new Page<PagosCompaniasDto>();
		page.setPage(dto.getPage());
		Criteria criteria = getCriteria();

		//
		// // TODO:add additional criteria
		// Find by name
		if (org.springframework.util.StringUtils.hasText(dto.getFindByName())) {
			Disjunction orCriteria = Restrictions.disjunction();
			criteria.createAlias("companias", "c");
			orCriteria.add(Restrictions.ilike("concepto", dto.getFindByName()
					.toUpperCase(), MatchMode.ANYWHERE));
			orCriteria.add(Restrictions.ilike("c.nombre", dto.getFindByName()
					.toUpperCase(), MatchMode.ANYWHERE));
			criteria.add(orCriteria);
		}
		//
		ScrollableResults scrollable = criteria.scroll();
		if (scrollable.last()) {
			page.setTotalCount(scrollable.getRowNumber() + 1);
		}
		criteria = getPaginationCriteria(dto, criteria);
		List<PagosCompaniasDto> data = new ArrayList<PagosCompaniasDto>();
		for (PagosCompanias e : (List<PagosCompanias>) criteria.list()) {
			PagosCompaniasDto ent = BeanUtils.copyProperties(e,
					PagosCompaniasDto.class);
			data.add(ent);
		}
		page.setData(data);
		page.setSuccess(true);
		return page;
	}
}
