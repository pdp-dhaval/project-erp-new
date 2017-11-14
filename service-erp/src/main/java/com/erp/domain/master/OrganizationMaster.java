package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * The persistent class for the organization_master database table.
 * 
 */
@Entity
@Table(name="organization_master")
@NamedQuery(name="OrganizationMaster.findAll", query="SELECT o FROM OrganizationMaster o")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class OrganizationMaster extends AccountMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrganizationMaster() {
		super();
	}
	public OrganizationMaster(Long erpId) {
		super(erpId);
	}
}