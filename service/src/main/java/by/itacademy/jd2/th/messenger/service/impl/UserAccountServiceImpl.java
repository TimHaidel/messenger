package by.itacademy.jd2.th.messenger.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itacademy.jd2.th.messenger.dao.api.IUserAccountDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

	private IUserAccountDao dao;

	@Autowired
	public UserAccountServiceImpl(IUserAccountDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IUserAccount getByEmail(String email) {
		IUserAccount entity = dao.findNickname(email);
		return entity;
	}

	@Override
	public IUserAccount createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IUserAccount entity) {
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
	public void save(final IUserAccount... entities) {
		final Date modified = new Date();
		for (final IUserAccount iUserAccount : entities) {

			iUserAccount.setUpdated(modified);
			iUserAccount.setCreated(modified);

		}

		dao.save(entities);
	}

	@Override
	public IUserAccount get(final Integer id) {
		final IUserAccount entity = dao.get(id);
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
	public List<IUserAccount> getAll() {
		final List<IUserAccount> all = dao.selectAll();
		return all;
	}

	@Override
	public List<IUserAccount> find(final UserAccountFilter filter) {
		return dao.find(filter);
	}
	
	@Override
	public List<IUserAccount> findForAutocomplete(String field) {
		return dao.findForAutocomplete(field);
	}

	@Override
	public long getCount(final UserAccountFilter filter) {
		return dao.getCount(filter);
	}

}