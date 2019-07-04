package by.itacademy.jd2.th.messenger.service;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;

public interface IUserGroupService {

    long getCount(final UserGroupFilter filter);

    List<IUserGroup> find(final UserGroupFilter filter);

    List<IUserGroup> getAll();

    void deleteAll();

    void delete(final Integer id);

    IUserGroup get(final Integer id);

    void save(final IUserGroup entity);

    IUserGroup createEntity();

    void save(IUserGroup... entity);

}
