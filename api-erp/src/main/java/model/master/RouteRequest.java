package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String routeName;

	public RouteRequest() {
		super();
	}

	public RouteRequest(Long id) {
		super(id);
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	@Override
	public String toString() {
		return "RouteMasterRequest [routeName=" + routeName + ", getId()=" + getErpId() + "]";
	}

}
