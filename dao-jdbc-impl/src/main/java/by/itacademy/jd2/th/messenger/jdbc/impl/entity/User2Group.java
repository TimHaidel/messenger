package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;

public class User2Group extends BaseEntity implements IUserToGroup {
	IUserGroup group;
	IUserAccount user;
	Integer groupRole;

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
	public Integer getGroupRole() {
		return groupRole;
	}

	@Override
	public void setGroupRole(Integer groupRole) {
		this.groupRole = groupRole;
	}

	@Override
	public String toString() {
		return "User2Group [group=" + group + ", user=" + user + ", groupRole=" + groupRole + "]";
	}

}
