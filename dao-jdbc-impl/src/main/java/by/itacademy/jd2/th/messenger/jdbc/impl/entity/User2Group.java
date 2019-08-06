package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;

public class User2Group extends BaseEntity implements IUserToUserGroup {
	IUserGroup group;
	IUserAccount user;
	Integer userGroupRole;

	@Override
	public IUserGroup getGroup() {
		return group;
	}

	@Override
	public void setGroup(final IUserGroup group) {
		this.group = group;
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
	public Integer getUserGroupRole() {
		return userGroupRole;
	}

	@Override
	public void setUserGroupRole(final Integer userGroupRole) {
		this.userGroupRole = userGroupRole;
	}

}
