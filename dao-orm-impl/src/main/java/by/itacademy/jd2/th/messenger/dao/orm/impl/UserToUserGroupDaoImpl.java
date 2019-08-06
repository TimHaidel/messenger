package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IUserToUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserToGroup;

@Repository
public class UserToUserGroupDaoImpl extends AbstractDaoImpl<IUserToUserGroup, Integer> implements IUserToUserGroupDao {

	protected UserToUserGroupDaoImpl() {
		super(UserToGroup.class);
	}

	@Override
	public IUserToUserGroup createEntity() {
		IUserToUserGroup userToUserGroup = new UserToGroup();
		return userToUserGroup;
	}

	@Override
	public List<IUserToUserGroup> find(UserToUserGroupFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(UserToUserGroupFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void save(IUserToUserGroup... entities) {
		throw new RuntimeException("Not implemented");

	}

}
