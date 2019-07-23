package by.itacademy.jd2.th.messenger.web.dto;

import java.util.Date;

public class MessageDTO {
	Integer id;
	String message;
	Integer parentMessage;
	Integer user;
	Integer userGroup;
	Date created;
	Date updated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getParentMessage() {
		return parentMessage;
	}

	public void setParentMessage(Integer parentMessage) {
		this.parentMessage = parentMessage;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}

}
