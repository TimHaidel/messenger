package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;

public interface IUserToUserGroupService {

	long getCount(final UserToUserGroupFilter filter);

	List<IUserToUserGroup> find(final UserToUserGroupFilter filter);

	List<IUserToUserGroup> getAll();

	void deleteAll();

	void delete(final Integer id);

	IUserToUserGroup get(final Integer id);

	void save(final IUserToUserGroup... entities);

	void save(final IUserToUserGroup entity);

	IUserToUserGroup createEntity();

}
