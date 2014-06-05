package com.lix.web;

import java.util.List;

public class Page<K> {
	private Integer totalCount;
	private Integer page;
	private List<K> data;
	private Boolean success;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<K> getData() {
		return data;
	}

	public void setData(List<K> data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}