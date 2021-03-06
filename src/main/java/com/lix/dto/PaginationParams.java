package com.lix.dto;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class PaginationParams {
	public static final String ORDER_ASC = "ASC";
	public static final String ORDER_DESC = "DESC";
	private Integer limit;
	private Integer page;
	private Integer start;
	private String sort;
	private String property;
	private String direction;
	private String findByName;
	private List<Sort> sorting;

	// private List<Map<String, String>> sort;

	// private List<Sort> sort = LazyList.decorate(new ArrayList<Sort>(),
	// FactoryUtils.instantiateFactory(Sort.class));

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	// public Sort getSort() {
	// return sort;
	// }
	//
	// public void setSort(Sort sort) {
	// this.sort = sort;
	// }

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<Sort> getSorting() {
		return sorting;
	}

	public void setSorting(List<Sort> sorting) {
		this.sorting = sorting;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		this.sorting = mapper.readValue(sort, new TypeReference<List<Sort>>() {
		});
		this.sort = sort;
	}

	public String getFindByName() {
		return findByName;
	}

	public void setFindByName(String findByName) {
		this.findByName = findByName;
	}
}
