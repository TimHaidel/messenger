package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;

public interface IUserToUserGroupService {

	long getCount(final UserToUserGroupFilter filter);

	List<IUserToUserGroup> find(final UserToUserGroupFilter filter);

	List<IUserToUserGroup> getAll();

	@Transactional
	void deleteAll();

	void delete(final Integer id);

	IUserToUserGroup get(final Integer id);

	@Transactional
	void save(final IUserToUserGroup... entities);

	@Transactional
	void save(final IUserToUserGroup entity);

	IUserToUserGroup createEntity();

}
