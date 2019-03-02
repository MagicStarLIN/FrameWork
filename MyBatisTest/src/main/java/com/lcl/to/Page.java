package com.lcl.to;

public class Page {
	
	private Integer startIndex;  //分页查询起点下标
	private Integer endIndex;  //分页查询终点下标
	private Integer pageSize;  //分页查询页面大小
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Page(Integer startIndex, Integer endIndex, Integer pageSize) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.pageSize = pageSize;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endIndex == null) ? 0 : endIndex.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((startIndex == null) ? 0 : startIndex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (endIndex == null) {
			if (other.endIndex != null)
				return false;
		} else if (!endIndex.equals(other.endIndex))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (startIndex == null) {
			if (other.startIndex != null)
				return false;
		} else if (!startIndex.equals(other.startIndex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Page [startIndex=" + startIndex + ", endIndex=" + endIndex + ", pageSize=" + pageSize + "]";
	}
	
}
