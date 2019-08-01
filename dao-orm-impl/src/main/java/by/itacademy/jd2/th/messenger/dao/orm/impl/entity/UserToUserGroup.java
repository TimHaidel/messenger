package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Entity;
import javax.persistence.Transient;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;

@Entity
public class UserToUserGroup extends BaseEntity implements IUserToUserGroup {
	@Transient
	IUserGroup userGroup;
	@Transient
	IUserAccount user;
	@Transient
	Integer userGroupRole;

	@Override
	public IUserGroup getUserGroup() {
		return userGroup;
	}

	@Override
	public void setUserGroup(final IUserGroup userGroup) {
		this.userGroup = userGroup;
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
