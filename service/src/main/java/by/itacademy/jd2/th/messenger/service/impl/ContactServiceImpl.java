package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IContactDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;
import by.itacademy.jd2.th.messenger.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {

	private IContactDao dao;

	@Autowired
	public ContactServiceImpl(IContactDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IContact createEntity() {
		return dao.createEntity();
	}

	@Override
	public IContact get(final Integer id) {
		final IContact entity = dao.get(id);
		return entity;
	}

	@Override
	public void save(final IContact entity) {
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
	public void save(final IContact... entities) {
		final Date modified = new Date();
		for (final IContact iContact : entities) {

			iContact.setUpdated(modified);
			iContact.setCreated(modified);

		}

		dao.save(entities);
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
	public List<IContact> getAll() {
		final List<IContact> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IContact> find(final ContactFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(final ContactFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public IContact getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}

}
