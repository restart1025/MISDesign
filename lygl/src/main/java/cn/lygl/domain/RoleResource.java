package cn.lygl.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="role_resource")
public class RoleResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private Role role;
	private Resource resource;
	
	@Id
	@ManyToOne(targetEntity=Role.class,cascade=CascadeType.ALL)
	@JoinColumn(name="role_sn",columnDefinition="VARCHAR(45)",referencedColumnName="role_sn")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Id
	@ManyToOne(targetEntity=Resource.class,cascade=CascadeType.ALL)
	@JoinColumn(name="resource_sn",columnDefinition="VARCHAR(45)", referencedColumnName="resource_sn")
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
