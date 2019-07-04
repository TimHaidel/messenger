package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;

public interface IUserAccountService {

    IUserAccount get(Integer id);

    List<IUserAccount> getAll();

    void save(IUserAccount entity);

    void save(IUserAccount... entity);

    void delete(Integer id);

    void deleteAll();

    IUserAccount createEntity();

    public List<IUserAccount> find(UserAccountFilter filter);

    public long getCount(UserAccountFilter filter);

}