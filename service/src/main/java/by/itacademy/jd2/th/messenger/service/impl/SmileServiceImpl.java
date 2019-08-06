package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.ISmileDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;
import by.itacademy.jd2.th.messenger.service.ISmileService;

@Service
public class SmileServiceImpl implements ISmileService {

	private ISmileDao dao;

	@Autowired
	public SmileServiceImpl(ISmileDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ISmile createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final ISmile entity) {
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
	public ISmile get(final Integer id) {
		final ISmile entity = dao.get(id);
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
	public List<ISmile> getAll() {
		final List<ISmile> all = dao.selectAll();
		return all;
	}

	@Override
	public List<ISmile> find(final SmileFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final SmileFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public ISmile getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}

}
