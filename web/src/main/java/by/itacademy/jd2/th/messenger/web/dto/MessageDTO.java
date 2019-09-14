package by.itacademy.jd2.th.messenger.web.dto;

import java.util.Date;

public class MessageDTO {
	private Integer id;
	private String message;
	private Integer parentMessage;
	private Integer userId;
	private Integer userGroupId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

}
