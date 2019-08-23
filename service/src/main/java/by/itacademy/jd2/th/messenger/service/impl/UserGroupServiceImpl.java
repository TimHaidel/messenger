package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IUserGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;

@Service
public class UserGroupServiceImpl implements IUserGroupService {

	private IUserGroupDao dao;

	@Autowired
	public UserGroupServiceImpl(IUserGroupDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IUserGroup createEntity() {
		return dao.createEntity();
	}

	@Override
	public IUserGroup save(final IUserGroup entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
		
		return entity;
	}

	@Override
	public IUserGroup get(final Integer id) {
		final IUserGroup entity = dao.get(id);
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
	public List<IUserGroup> getAll() {
		final List<IUserGroup> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IUserGroup> find(final UserGroupFilter filter) {
		return dao.find(filter);
	}

	@Override
	public Integer findGroupId(Integer user1, Integer user2) {
		return dao.findGroupId(user1, user2);

	}

	@Override
	public long getCount(final UserGroupFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public void save(final IUserGroup... entities) {
		final Date modified = new Date();
		for (final IUserGroup iGroup : entities) {

			iGroup.setUpdated(modified);
			iGroup.setCreated(modified);

		}

		dao.save(entities);

	}
}
