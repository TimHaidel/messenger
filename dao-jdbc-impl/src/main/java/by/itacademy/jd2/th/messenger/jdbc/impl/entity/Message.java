package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import java.util.Set;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class Message extends BaseEntity implements IMessage {
	String message;
	IMessage parrentMessage;
	IUserAccount user;
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

	@Override
	public void setUserAccounts(Set<IUserAccount> userAccounts) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<IUserAccount> getUserAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMessage getParentMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttachment(IAttachment attachment) {
		// TODO Auto-generated method stub

	}

	@Override
	public IAttachment getAttachment() {
		// TODO Auto-generated method stub
		return null;
	}

}
