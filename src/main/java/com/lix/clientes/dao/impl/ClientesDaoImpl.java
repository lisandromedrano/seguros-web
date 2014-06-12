/*
 * Created on 14 nov 2013 ( Time 17:20:05 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.lix.clientes.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lix.clientes.dao.ClientesDao;
import com.lix.clientes.dto.ClientesDto;
import com.lix.clientes.model.Clientes;
import com.lix.dao.AbstractHibernateDao;
import com.lix.util.BeanUtils;
import com.lix.web.Page;

/**
 * Basic persistence operations for entity "Clientes"
 * 
 * 
 * @author Lisandro
 * 
 */
@Repository("clientesDao")
public class ClientesDaoImpl extends AbstractHibernateDao<Clientes, Integer>
		implements ClientesDao {

	@PostConstruct
	public void setInstance() {
		setClazz(Clientes.class);
	}

	@Override
	@Transactional
	public List<Clientes> findByName(String name) {
		Criteria criteria = getCurrentSession()
				.createCriteria((Clientes.class));
		criteria.add(Restrictions.like("nombre", name.toUpperCase(),
				MatchMode.ANYWHERE));
		return (List<Clientes>) criteria.list();
	}

	@Override
	@Transactional
	public Page<ClientesDto> findPage(ClientesDto dto) {
		Page<ClientesDto> page = new Page<ClientesDto>();
		page.setPage(dto.getPage());
		Criteria criteria = getCriteria();
		//
		ScrollableResults scrollable = criteria.scroll();
		if (scrollable.last()) {
			page.setTotalCount(scrollable.getRowNumber() + 1);
		}
		criteria = getPaginationCriteria(dto, criteria);
		//
		// // TODO:add additional criteria
		// Find by name
		if (org.springframework.util.StringUtils.hasText(dto.getFindByName())) {

			// criteria.add(Restrictions.or(Restrictions.ilike("nombre",
			// dto.getFindByName(), MatchMode.ANYWHERE), Restrictions
			// .ilike("apellido", dto.getFindByName(), MatchMode.ANYWHERE)));
			// criteria.add(Restrictions.ilike("nombre", dto.getFindByName(),
			// MatchMode.ANYWHERE));
			criteria.add(Restrictions.or(Restrictions.ilike("nombre", dto
					.getFindByName().toUpperCase(), MatchMode.ANYWHERE),
					Restrictions.ilike("apellido", dto.getFindByName()
							.toUpperCase(), MatchMode.ANYWHERE)));
		}
		List<ClientesDto> data = new ArrayList<ClientesDto>();
		for (Clientes e : (List<Clientes>) criteria.list()) {
			ClientesDto ent = BeanUtils.copyProperties(e, ClientesDto.class);
			data.add(ent);
		}
		page.setData(data);
		page.setSuccess(true);
		// // return (List<Modules>) criteria.list();
		return page;
	}
}
