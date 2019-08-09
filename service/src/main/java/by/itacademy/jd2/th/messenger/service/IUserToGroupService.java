package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;

public interface IUserToGroupService {

	long getCount(final UserToUserGroupFilter filter);

	List<IUserToGroup> find(final UserToUserGroupFilter filter);

	List<IUserToGroup> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	IUserToGroup getFullInfo(final Integer id);

	@Transactional
	void save(final IUserToGroup... entities);

	@Transactional
	void save(final IUserToGroup entity);

	IUserToGroup createEntity();

	Object get(Integer id);

}
