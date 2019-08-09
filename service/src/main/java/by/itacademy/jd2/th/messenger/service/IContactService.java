package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;

public interface IContactService {

	long getCount(final ContactFilter filter);

	List<IContact> find(final ContactFilter filter);

	List<IContact> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	IContact get(final Integer id);

	IContact createEntity();

	@Transactional
	void save(final IContact entity);

	@Transactional
	void save(final IContact... entities);

	IContact getFullInfo(Integer id);

}
