package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name="uborrow")
public class UBorrow {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="Book_Name")
	private String bname;
	
	@Column(name="Book_Author")
	private String bauthor;
	
	@Column(name="Published_Date")
	private String pdate;
	
	@Column(name="Publisher")
	private String bpublisher;
	
	@Column(name="Borrowed_Date")
	private String bdate;
	
	@Column(name="Return_Date")
	private String rdate;
	
	@Column(name="uname")
	private String uName;
	
	@Column(name="status")
	private String status;
	
	
	public UBorrow()
	{
		
	}


	
	
	public UBorrow(String bname, String bauthor, String pdate, String bpublisher, String bdate, String rdate,
			String uName,String status) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.pdate = pdate;
		this.bpublisher = bpublisher;
		this.bdate = bdate;
		this.rdate = rdate;
		this.uName = uName;
		this.status=status;
	}




	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getBauthor() {
		return bauthor;
	}


	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}


	public String getPdate() {
		return pdate;
	}


	public void setPdate(String pdate) {
		this.pdate = pdate;
	}


	public String getBpublisher() {
		return bpublisher;
	}


	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public String getRdate() {
		return rdate;
	}


	public void setRdate(String rdate) {
		this.rdate = rdate;
	}




	public String getuName() {
		return uName;
	}




	public void setuName(String uName) {
		this.uName = uName;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}


	
	
	

}
