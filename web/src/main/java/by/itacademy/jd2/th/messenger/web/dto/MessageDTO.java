package by.itacademy.jd2.th.messenger.web.dto;

import java.util.Date;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class MessageDTO {
	Integer id;
	String message;
	Integer parentMessage;
	IUserAccount user;
	IUserGroup userGroup;
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

	public IUserAccount getUser() {
		return user;
	}

	public void setUser(IUserAccount user) {
		this.user = user;
	}

	public IUserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(IUserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
