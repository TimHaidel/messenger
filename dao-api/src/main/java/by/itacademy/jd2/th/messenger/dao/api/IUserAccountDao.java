package by.itacademy.jd2.th.messenger.dao.api;

import java.sql.SQLException;
import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;

public interface IUserAccountDao extends IDao<IUserAccount, Integer> {

    List<IUserAccount> find(UserAccountFilter filter);

    long getCount(UserAccountFilter filter);

    void save(IUserAccount... entities);

	IUserAccount findNickname(String username) ;

}
