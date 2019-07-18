package by.itacademy.jd2.th.messenger.web.dto;

import java.util.Date;

public class ContactDTO {
	
	Integer id;
	Integer initiatorId;
	Integer acceptorId;
	Integer status;
	Date created;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInitiatorId() {
		return initiatorId;
	}
	public void setInitiatorId(Integer initiatorId) {
		this.initiatorId = initiatorId;
	}
	public Integer getAcceptorId() {
		return acceptorId;
	}
	public void setAcceptorId(Integer acceptorId) {
		this.acceptorId = acceptorId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	

}
