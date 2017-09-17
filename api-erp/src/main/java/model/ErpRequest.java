package model;

public class ErpRequest {

	private Long id;
	
	private Integer classId; // 
	
	private Integer startNo; // is startNo -1 and endNo is -1 then get all list
	
	private Integer endNo; // is startNo -1 and endNo is -1 then get all list

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

	public Integer getStartNo() {
		return startNo;
	}

	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	public Integer getEndNo() {
		return endNo;
	}

	public void setEndNo(Integer endNo) {
		this.endNo = endNo;
	}
	
	
	
	
}
