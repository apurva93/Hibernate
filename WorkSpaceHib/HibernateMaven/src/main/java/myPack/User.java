package myPack;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserTable")
public class User {

	@Id
	@Column(name = "ID")
	private int userId;
	@Column(name="NAME")
	private String userName;
	@Column(name="OWNER")
	private Date CreatedBy;
	@Column(name="DATE")
	private Date CreatedDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(Date createdBy) {
		CreatedBy = createdBy;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	} 
}
