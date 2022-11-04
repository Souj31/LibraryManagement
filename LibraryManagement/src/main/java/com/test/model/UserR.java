package com.test.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
public class UserR {
	
	
	//private static final long serialVersionUID = 1L;

	//private static Logger logger = LoggerFactory.getLogger(UserR.class);
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="firstname")
	//@Getter @Setter
	private String fname;
	
	@Column(name="lastname")
	//@Getter @Setter
	private String lname;
	
	@Email
	@Column(name="email")
	//@Getter @Setter
	private String email;
	
	@Column(name="phoneno")
	//@Getter @Setter
	private String phoneno;
	
	@Column(name="address")
	//@Getter @Setter
	private String address;
	
	
	@Column(name="username")
	//@Getter @Setter
	private String uname;
	
	@Column(name="password")
	//@Getter @Setter
	private String password;
	
	public UserR()
	{
		
	}
	
	

	

	public UserR(String fname, String lname, @Email String email, String phoneno, String address, String uname,
			String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phoneno = phoneno;
		this.address = address;
		this.uname = uname;
		this.password = password;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	

}
