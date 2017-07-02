package cn.lygl.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;


@Entity
@Table(name = "dormitory")
public class Dormitory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//主键，自动增长
	private DormBuild dormBuild;//宿舍楼
	private DormBuildSn dormBuildSn;//宿舍楼号吗
	private String DormSn;//大宿舍号码
	private Float Electricity;//电量
	private Set<Person> persons = new HashSet<Person>(0);
	private Set<Record> records = new HashSet<Record>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "dorm_sn", length = 45, unique = true, nullable = false)
	public String getDormSn() {
		return DormSn;
	}
	public void setDormSn(String dormSn) {
		DormSn = dormSn;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="dorm_build",nullable=false)
	public DormBuild getDormBuild() {
		return dormBuild;
	}
	public void setDormBuild(DormBuild dormBuild) {
		this.dormBuild = dormBuild;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="dorm_build_sn",nullable=false)
	public DormBuildSn getDormBuildSn() {
		return dormBuildSn;
	}
	public void setDormBuildSn(DormBuildSn dormBuildSn) {
		this.dormBuildSn = dormBuildSn;
	}
	@Column(name = "electricity")
	public Float getElectricity() {
		return Electricity;
	}
	public void setElectricity(Float electricity) {
		Electricity = electricity;
	}
	@OneToMany(targetEntity = Person.class,mappedBy = "dormitory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JSON(serialize = false)
	public Set<Person> getPersons() {
		return persons;
	}
	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	@OneToMany(targetEntity = Person.class,mappedBy = "dormitory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JSON(serialize = false)
	public Set<Record> getRecords() {
		return records;
	}
	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	
	
}
