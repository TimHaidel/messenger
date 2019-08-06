package by.itacademy.jd2.th.messenger.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.itacademy.jd2.th.messenger.dao.api.IUserAccountDao;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserAccount;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

	protected UserAccountDaoImpl() {
		super(UserAccount.class);
	}

	@Override
	public IUserAccount createEntity() {
		IUserAccount user = new UserAccount();
		return user;
	}

	@Override
	public List<IUserAccount> find(UserAccountFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public long getCount(UserAccountFilter filter) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void save(IUserAccount... entities) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public IUserAccount findNickname(String username) {
		throw new RuntimeException("Not implemented");
	}

}
