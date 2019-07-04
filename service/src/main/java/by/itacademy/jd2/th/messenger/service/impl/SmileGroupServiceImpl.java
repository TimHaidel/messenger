package by.itacademy.jd2.th.messenger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.ISmileGroupDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;

@Service
public class SmileGroupServiceImpl implements ISmileGroupService {

	private ISmileGroupDao dao;

	@Autowired
	public SmileGroupServiceImpl(ISmileGroupDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ISmileGroup createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final ISmileGroup entity) {
		if (entity.getId() == null) {
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public ISmileGroup get(final Integer id) {
		final ISmileGroup entity = dao.get(id);
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
	public List<ISmileGroup> getAll() {
		final List<ISmileGroup> all = dao.selectAll();
		return all;
	}

	@Override
	public List<ISmileGroup> find(final SmileGroupFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final SmileGroupFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public void save(final ISmileGroup... entities) {

		dao.save(entities);

	}

}
