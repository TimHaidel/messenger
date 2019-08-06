package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;

@Entity
@Table(name = "user_2_group")
public class UserToGroup extends BaseEntity implements IUserToUserGroup {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserGroup.class)
	private IUserGroup group;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
	private IUserAccount user;
	@Transient
	private Integer userGroupRole;

	@Override
	public IUserGroup getGroup() {
		return group;
	}

	@Override
	public void setGroup(IUserGroup group) {
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

	@Override
	public String toString() {
		return "UserToGroup [group=" + group + ", user=" + user + ", userGroupRole=" + userGroupRole + "]";
	}

}
