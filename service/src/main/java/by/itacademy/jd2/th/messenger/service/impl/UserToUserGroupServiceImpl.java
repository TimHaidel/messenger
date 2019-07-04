package by.itacademy.jd2.th.messenger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IUserToUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;
import by.itacademy.jd2.th.messenger.service.IUserToUserGroupService;

@Service
public class UserToUserGroupServiceImpl implements IUserToUserGroupService {

	private IUserToUserGroupDao dao;

	@Autowired
	public UserToUserGroupServiceImpl(IUserToUserGroupDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IUserToUserGroup createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IUserToUserGroup entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public void save(final IUserToUserGroup... entities) {
		dao.save(entities);
	}

	@Override
	public IUserToUserGroup get(final Integer id) {
		final IUserToUserGroup entity = dao.get(id);
		return entity;
	}

	@Override
	public void delete(final Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public List<IUserToUserGroup> getAll() {
		final List<IUserToUserGroup> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IUserToUserGroup> find(final UserToUserGroupFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final UserToUserGroupFilter filter) {
		return dao.getCount(filter);
	}
}
