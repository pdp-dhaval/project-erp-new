package model.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErpResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer status;

	private String message;

	private Object data;
	
	private List<?> dataList = Collections.emptyList();

	public ErpResponse() {
		super();
	}

	public ErpResponse(String message,Integer status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public ErpResponse(String message,Integer status,Object data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
	
}
