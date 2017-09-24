package com.erp.domain.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the route_master database table.
 * 
 */
@Entity
@Table(name="route_master")
public class RouteMaster extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;
	
	@Column(name="route_name")
	private String routeName;

	public RouteMaster() {
		super();
	}
	
	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	public ERPMaster getErpMaster() {
		return erpMaster;
	}

	public void setErpMaster(ERPMaster erpMaster) {
		this.erpMaster = erpMaster;
	}

	@Override
	public String toString() {
		return "RouteMaster [getId()=" + getId() + "]";
	}

}