package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import javax.transaction.Transactional;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;

public interface IUserAccountService {

	IUserAccount get(Integer id);

	List<IUserAccount> getAll();

	@Transactional
	void save(IUserAccount entity);

	@Transactional
	void save(IUserAccount... entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	IUserAccount createEntity();

	public List<IUserAccount> find(UserAccountFilter filter);

	public long getCount(UserAccountFilter filter);

	IUserAccount getByEmail(String email);

}