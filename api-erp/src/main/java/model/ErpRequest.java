package model;

public class ErpRequest {

	private Long id;
	
	private Integer classId; // 
	
	private Integer pageSize; // is startNo -1 and endNo is -1 then get all list
	
	private Integer pageNo; // is startNo -1 and endNo is -1 then get all list

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

		
	
}
