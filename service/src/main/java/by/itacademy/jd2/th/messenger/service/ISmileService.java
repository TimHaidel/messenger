package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;

public interface ISmileService {

	long getCount(final SmileFilter filter);

	List<ISmile> find(final SmileFilter filter);

	List<ISmile> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	ISmile get(final Integer id);

	@Transactional
	void save(final ISmile entity);

	ISmile createEntity();

}
