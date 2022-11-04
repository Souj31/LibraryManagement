package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="Book_No")
	@Getter @Setter
	private Integer id;
	
	@Column(name="Book_Name")
	@Getter @Setter
	private String bname;
	
	@Column(name="Book_Author")
	@Getter @Setter
	private String bauthor;
	
	@Column(name="Book_Copies")
	@Getter @Setter
	private String bcopies;
	
	@Column(name="Book_Publisher")
	@Getter @Setter
	private String bpublisher;
	
	@Column(name="Published_Date")
	@Getter @Setter
	private String pdate;

	public Book()
	{
		
	}
	
	
	

	public Book(Integer id, String bname, String bauthor, String bcopies, String bpublisher, String pdate) {
		super();
		this.id = id;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bcopies = bcopies;
		this.bpublisher = bpublisher;
		this.pdate = pdate;
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

	public String getBcopies() {
		return bcopies;
	}

	public void setBcopies(String bcopies) {
		this.bcopies = bcopies;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	
	
	
	

}
