package cn.lygl.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//主键，自动增长
	private Dormitory dormitory;//大宿舍编号
	private int DormNum;//宿舍号最后一位
	private RecordType RecordType;//记录类型:电费、水费、报修费用
	private Float DormPrice;//费用
	private java.time.LocalDateTime RecordTime;//记录时间
	private String Remark;//备注
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(targetEntity = Dormitory.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "dorm_sn",referencedColumnName = "dorm_sn", nullable = false)
	public Dormitory getDormitory() {
		return dormitory;
	}
	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}
	@Column(name = "dorm_num", length = 11, nullable = true)
	public int getDormNum() {
		return DormNum;
	}
	public void setDormNum(int dormNum) {
		DormNum = dormNum;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "record_type", nullable = false)
	public RecordType getRecordType() {
		return RecordType;
	}
	public void setRecordType(RecordType recordType) {
		RecordType = recordType;
	}
	@Column(name = "dorm_price")
	public Float getDormPrice() {
		return DormPrice;
	}
	public void setDormPrice(Float dormPrice) {
		DormPrice = dormPrice;
	}
	@Column(name = "record_time")
	public java.time.LocalDateTime getRecordTime() {
		return RecordTime;
	}
	public void setRecordTime(java.time.LocalDateTime recordTime) {
		RecordTime = recordTime;
	}
	@Column(name = "record_remark")
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
