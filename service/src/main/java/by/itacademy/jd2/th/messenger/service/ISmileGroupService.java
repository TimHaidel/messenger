package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;

public interface ISmileGroupService {
	@Transactional
	void save(final ISmileGroup... entities);

	long getCount(final SmileGroupFilter filter);

	List<ISmileGroup> find(final SmileGroupFilter filter);

	List<ISmileGroup> getAll();

	@Transactional
	void deleteAll();

	@Transactional
	void delete(final Integer id);

	ISmileGroup get(final Integer id);

	@Transactional
	void save(final ISmileGroup entity);

	ISmileGroup createEntity();

}
