package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserGroup;

@Repository
public class UserGroupDaoImpl extends AbstractDaoImpl<IUserGroup, Integer> implements IUserGroupDao {

	protected UserGroupDaoImpl() {
		super(UserGroup.class);
	}

	@Override
	public IUserGroup createEntity() {
		IUserGroup userGroup = new UserGroup();
		return userGroup;
	}

	@Override
	public List<IUserGroup> find(UserGroupFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(UserGroupFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void save(IUserGroup... entities) {
		throw new RuntimeException("Not implemented");

	}

}
