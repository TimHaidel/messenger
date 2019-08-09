package by.itacademy.jd2.th.messenger.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;

@Entity
@Table(name = "user_2_group")
public class UserToGroup extends BaseEntity implements IUserToGroup {
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserGroup.class)
	private IUserGroup group;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
	private IUserAccount user;
	@Column
	private Integer groupRole;

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
	public Integer getGroupRole() {
		return groupRole;
	}

	@Override
	public void setGroupRole(Integer groupRole) {
		this.groupRole = groupRole;
	}

	@Override
	public String toString() {
		return "UserToGroup [group=" + group + ", user=" + user + ", groupRole=" + groupRole + "]";
	}


}
