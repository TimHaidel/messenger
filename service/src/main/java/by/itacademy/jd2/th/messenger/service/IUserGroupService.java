package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;

public interface IUserGroupService {

	long getCount(final UserGroupFilter filter);

	List<IUserGroup> find(final UserGroupFilter filter);

	List<IUserGroup> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	IUserGroup get(final Integer id);

	@Transactional
	IUserGroup save(final IUserGroup entity);

	IUserGroup createEntity();

	Integer findGroupId(Integer user1, Integer user2);

	void save(final IUserGroup... entities);

	List<IUserGroup> getLoggedUserGroups(Integer loggedUserId);

}
