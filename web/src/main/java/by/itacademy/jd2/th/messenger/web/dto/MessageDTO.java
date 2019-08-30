package by.itacademy.jd2.th.messenger.web.dto;

import java.util.Date;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class MessageDTO {
	private Integer id;
	private String message;
	private Integer parentMessage;
	private IUserAccount user;
	private IUserGroup userGroup;
	private Date created;
	private Date updated;
	
	private boolean isCurrentUser;
	
	
	

	public boolean isCurrentUser() {
		return isCurrentUser;
	}

	public void setCurrentUser(boolean isCurrentUser) {
		this.isCurrentUser = isCurrentUser;
	}

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

	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", message=" + message + ", user=" + user + ", userGroup=" + userGroup + "]";
	}

}
