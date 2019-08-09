package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IUserToGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;
import by.itacademy.jd2.th.messenger.service.IUserToGroupService;

@Service
public class UserToGroupServiceImpl implements IUserToGroupService {

	private IUserToGroupDao dao;

	@Autowired
	public UserToGroupServiceImpl(IUserToGroupDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IUserToGroup createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IUserToGroup entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public void save(final IUserToGroup... entities) {
		final Date modified = new Date();
		for (final IUserToGroup iUserToUserGroup : entities) {

			iUserToUserGroup.setUpdated(modified);
			iUserToUserGroup.setCreated(modified);

		}
		dao.save(entities);
	}

	@Override
	public IUserToGroup getFullInfo(final Integer id) {
		final IUserToGroup entity = dao.getFullInfo(id);
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
	public List<IUserToGroup> getAll() {
		final List<IUserToGroup> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IUserToGroup> find(final UserToUserGroupFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final UserToUserGroupFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public Object get(Integer id) {
		return dao.get(id);
	}
}
