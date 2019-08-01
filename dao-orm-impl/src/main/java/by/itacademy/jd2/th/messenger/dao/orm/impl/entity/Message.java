package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

@Entity
public class Message extends BaseEntity implements IMessage {
	@Column
	String message;
	@Transient
	IMessage parrentMessage;
	@Transient
	IUserAccount user;
	@Transient
	IUserGroup userGroup;

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public IMessage getParrentMessage() {
		return parrentMessage;
	}

	@Override
	public void setParentMessage(final IMessage parrentMessage) {
		this.parrentMessage = parrentMessage;
	}

	@Override
	public IUserAccount getUser() {
		return user;
	}

	@Override
	public void setUser(final IUserAccount user) {
		this.user = user;
	}

	@Override
	public IUserGroup getUserGroup() {
		return userGroup;
	}

	@Override
	public void setUserGroup(final IUserGroup group) {
		this.userGroup = group;
	}

}
