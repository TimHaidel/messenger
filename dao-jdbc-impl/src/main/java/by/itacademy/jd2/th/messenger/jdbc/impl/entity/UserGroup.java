package by.itacademy.jd2.th.messenger.jdbc.impl.entity;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;

public class UserGroup extends BaseEntity implements IUserGroup {
	private String name;
	private Integer usersCount;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public Integer getUsersCount() {
		return usersCount;
	}

	@Override
	public void setUsersCount(Integer usersCount) {
		this.usersCount = usersCount;
	}

}
