package by.itacademy.jd2.th.messenger.dao.api;

import java.util.List;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserToUserGroupFilter;

public interface IUserToUserGroupDao extends IDao<IUserToUserGroup, Integer> {

	List<IUserToUserGroup> find(UserToUserGroupFilter filter);

	long getCount(UserToUserGroupFilter filter);

	void save(IUserToUserGroup... entities);

}
